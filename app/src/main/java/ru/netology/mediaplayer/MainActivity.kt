package ru.netology.mediaplayer

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val observerMedia = MediaLifecycleObserver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(observerMedia)
        val button = findViewById<Button>(R.id.play)

        button.setOnClickListener {
            observerMedia.apply {
                    mediaPlayer?.setDataSource("https://raw.githubusercontent.com/netology-code/andad-homeworks/master/09_multimedia/data/1.mp3")
            }.play()
        }
    }
}
