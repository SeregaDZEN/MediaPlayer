package ru.netology.mediaplayer

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.viewmodel.viewModelFactory
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import ru.netology.mediaplayer.adapter.TrackAdapter
import ru.netology.mediaplayer.databinding.ActivityMainBinding
import ru.netology.mediaplayer.model.Music
import ru.netology.mediaplayer.model.Track
import ru.netology.mediaplayer.repository.MusicRepository
import ru.netology.mediaplayer.repository.MusicRepositoryImpl
import ru.netology.mediaplayer.viewmodel.MusicViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val observerMedia = MediaLifecycleObserver()

    val viewModel: MusicViewModel by viewModels ()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycle.addObserver(observerMedia)
        val rec = binding.list
        val adapter = TrackAdapter()
        rec.adapter = adapter


        val track = Track(1, "12", "SDFPIpu", "Abba") // моковые данные - настоящие
        val track2 = Track(2, "12", "SLL", "AbOOba") // моковые данные - настоящие


        val listTrack =
            listOf(track, track2, track2, track2, track2, track, track, track, track, track2, track)

        val music = Music(1, "lalala", "lalo", "Джеки чан", "vou vou", "сcomon", listTrack)
        binding.artistText.text = music.artist
        binding.genre.text = music.genre



        adapter.submitList(music.tracks)


        // val button = binding.

//        button.setOnClickListener {
//            observerMedia.apply {
//                mediaPlayer?.setDataSource("https://raw.githubusercontent.com/netology-code/andad-homeworks/master/09_multimedia/data/1.mp3")
//            }.play()
//        }
    }
}
// 1 подключить биндинг +
// 2 создать ресайклер (пустой)
// 3 создать элемент для ресайклера вью для названия и настроек (вьюшки в полосу)
// 4 на активити Маин создать поля под шапку xml text view
// 5 под шапку положить ресайклер
// 6 в МА create okHHTp
// 7 create data class with poles
// 8 запросить через окХтипи по урл наш дата класс  ( в кот пунтке 7) научится получать эти джесон файл
// 9 связать полученные данные с полями шапки
// 10 полученный лист ссвязть с ресайклером
// 11 научится воспроизв музыку


fun parseJson(json: String): Music {
    val gson = Gson()
    return gson.fromJson(json, Music::class.java)
}


// 1 - cверстать шапку коректно отобрадалсь превью (верстка)
// 2 - в МА создать класс Музик
// 3 заменить в АДапторе трек на трек из музиков
// 4 в МА пополнить шапку данными из 2го пункта
// 5 сделать вьюмодельку
//

// хилт добавить
// прописать в МА анатацию  + прписать нал вью моделью
// создать класс DI и в нём прорастить ретрофит сервис и репозиторий
// 
