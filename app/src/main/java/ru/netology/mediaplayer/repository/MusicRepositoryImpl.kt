package ru.netology.mediaplayer.repository

import android.content.Context
import android.util.Log
import kotlinx.coroutines.flow.Flow
import okhttp3.Call
import okhttp3.Callback
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class MusicRepositoryImpl(private val context: Context) : MusicRepository {
    companion object {
        private const val BASE_URL =
            "https://raw.githubusercontent.com/netology-code/andad-homeworks/master/09_multimedia/data/album.json"
    }

    override suspend fun getTrack(url: String) {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url(BASE_URL)
            .build()
        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                Log.e("error", e.toString())
            }

            override fun onResponse(call: Call, response: Response) {
              if (response.isSuccessful){
                  val data = response.body?.toString()
              } else print("error")
            }

        })
    }


}

