package ru.netology.mediaplayer;

import android.media.MediaPlayer
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

class MediaLifecycleObserver : LifecycleEventObserver {
    private var mediaPlayer: MediaPlayer? = MediaPlayer()

    fun play() {
        mediaPlayer?.setOnPreparedListener {
            it.start()
        }
        mediaPlayer?.prepareAsync()
    }
    fun resetMediaPlayer() {
        mediaPlayer?.reset()
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_PAUSE -> mediaPlayer?.pause()
            Lifecycle.Event.ON_STOP -> {
                mediaPlayer?.release()
                mediaPlayer = null
            }

            Lifecycle.Event.ON_DESTROY -> source.lifecycle.removeObserver(this)
            else -> Unit

        }

    }
}
