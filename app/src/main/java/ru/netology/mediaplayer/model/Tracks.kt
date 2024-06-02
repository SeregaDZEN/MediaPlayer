package ru.netology.mediaplayer.model

import com.google.gson.annotations.SerializedName

data class Track(
    @SerializedName("id")
    val id: Long,
    @SerializedName("file")
    val file: String,
    @SerializedName("albumName")
    val albumName: String,
    @SerializedName("name")
    val name: String,
)