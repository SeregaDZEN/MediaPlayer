package ru.netology.mediaplayer.viewmodel

import android.media.MediaPlayer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.netology.mediaplayer.api.RetrofitService.BASE_URL
import ru.netology.mediaplayer.repository.MusicRepository
import javax.inject.Inject

@HiltViewModel
class MusicViewModel @Inject constructor(
    private val repository: MusicRepository,

    ) : ViewModel() {
    private val mediaPlayer = MediaPlayer()
    private val _state = MutableStateFlow(MusicState())
    val state = _state.asStateFlow()


    init {
        load()

        mediaPlayer.setOnCompletionListener {
            val tracks = _state.value.tracks
            val played = tracks.indexOfFirst { it.playing }

            val nextIndex = played + 1
            val safeIndex = if (nextIndex > tracks.size) {
                0
            } else {
                nextIndex
            }
            play(tracks[safeIndex].file)

        }
    }

    private fun play(file: String) {
        _state.update { state ->
            state.copy(
                tracks = state.tracks.map {
                    if (it.file == file) {
                        val playing = it.playing
                        if (playing) {
                            mediaPlayer.stop()
                        } else {
                            playInternal(file)
                        }
                        it.copy(playing = !it.playing)
                    } else {
                        it.copy(playing = false)
                    }
                }
            )
        }
    }

    private fun playInternal(file: String) {
        mediaPlayer.reset()
        mediaPlayer.setDataSource("${BASE_URL}$file")
        mediaPlayer.setOnPreparedListener {
            it.start()
        }
        mediaPlayer.prepareAsync()
    }

    private fun load() {
        _state.update {
            it.copy(status = Status.LOADING)
        }
        viewModelScope.launch {
            runCatching {
                repository.getTracks()
            }
                .onFailure {
                    _state.update {
                        it.copy(status = Status.ERROR)
                    }
                }
                .onSuccess { music ->
                    _state.update {
                        it.copy(
                            status = Status.IDLE,
                            tracks = music.tracks.map(TrackUiModel::fromModel)

                        )
                    }
                }
        }
    }
}