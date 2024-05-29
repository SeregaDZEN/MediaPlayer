package ru.netology.mediaplayer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import ru.netology.mediaplayer.adapter.TrackAdapter
import ru.netology.mediaplayer.databinding.ActivityMainBinding
import ru.netology.mediaplayer.dto.Music
import ru.netology.mediaplayer.dto.Track

class MainActivity : AppCompatActivity() {


    private val json = """{
        "id": 1,
        "title": "SoundHelix Songs",
        "subtitle": "www.soundhelix.com",
        "artist": "T. Schürger",
        "published": [2009, 2010, 2011, 2013],
        "genre": "electronic",
        "tracks": [
            {"id": 1, "file": "1.mp3"}
        ]
    }"""
    val musicData = parseJson(json)


//    if (response.isSuccessful) {
//        val responseData = response.body?.string()
//        println(responseData)
//    } else {
//        println("Request Failed: ${response.code}")
//    }

    private lateinit var binding: ActivityMainBinding

    private val observerMedia = MediaLifecycleObserver()


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        lifecycle.addObserver(observerMedia)
        val rec = binding.list
        val adapter = TrackAdapter()
        rec.adapter = adapter

        val track = Track(1,"12","SDFPIpu","Abba") // моковые данные - настоящие

        adapter.submitList(listOf(track))


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
// заменить в АДапторе трек на трек из музиков
// в МА пополнить шапку данными из 2го пункта
// сделать вьюмодельку
//
