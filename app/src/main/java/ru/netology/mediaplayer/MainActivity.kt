package ru.netology.mediaplayer

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.lifecycle.viewmodel.viewModelFactory
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import ru.netology.mediaplayer.adapter.TrackAdapter
import ru.netology.mediaplayer.api.ApiService
import ru.netology.mediaplayer.api.RetrofitService
import ru.netology.mediaplayer.databinding.ActivityMainBinding
import ru.netology.mediaplayer.model.Music
import ru.netology.mediaplayer.model.Track
import ru.netology.mediaplayer.repository.MusicRepository
import ru.netology.mediaplayer.repository.MusicRepositoryImpl
import ru.netology.mediaplayer.viewmodel.MusicViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {



    @Inject
    lateinit var ret: RetrofitService

    @Inject
    lateinit var api: ApiService


    private val observerMedia = MediaLifecycleObserver()

    val viewModel: MusicViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {

        ret.apiService

        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycle.addObserver(observerMedia)
        val rec = binding.list
        val adapter = TrackAdapter()
        rec.adapter = adapter


        val track = Track(1, "12", "SDFPIpu", "Abba") // моковые данные - симуляция данных
        val track2 = Track(2, "12", "SLL", "AbOOba")


        val listTrack =
            listOf(track, track2, track2, track2, track2, track, track, track, track, track2, track)

        val music = Music(1, "lalala", "lalo", "Джеки чан", "vou vou", "сcomon", listTrack)
        binding.artistText.text = music.artist
        binding.genre.text = music.genre


        adapter.submitList(music.tracks)


    }
}

