package ru.netology.mediaplayer

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // private val observerMedia = MediaLifecycleObserver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // lifecycle.addObserver(observerMedia)
        val button = findViewById<Button>(R.id.play)
        val videoView = findViewById<VideoView>(R.id.videoView)

        button.setOnClickListener {
            videoView.apply {
                setMediaController(MediaController(this@MainActivity))
                setVideoURI(
                    Uri.parse("https://raw.githubusercontent.com/netology-code/andad-homeworks/master/09_multimedia/data/1.mp3")
                )
                setOnPreparedListener {
                    start()
                }
                setOnCompletionListener {
                    stopPlayback()
                }
            }
        }
    }
}
