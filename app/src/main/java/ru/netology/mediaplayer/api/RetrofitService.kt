package ru.netology.mediaplayer.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object  RetrofitService {

    const val BASE_URL =
        "https://raw.githubusercontent.com/netology-code/andad-homeworks/master/09_multimedia/data/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}