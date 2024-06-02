package ru.netology.mediaplayer.api

import retrofit2.Response
import retrofit2.http.GET
import ru.netology.mediaplayer.model.Music

interface ApiService {
    @GET("album.json")
    suspend fun getTracks(): Music

    }

