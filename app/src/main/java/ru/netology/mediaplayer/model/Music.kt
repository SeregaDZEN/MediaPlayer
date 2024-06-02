package ru.netology.mediaplayer.model

import com.google.gson.annotations.SerializedName

data class Music(
    @SerializedName("id")
    val id: Long,
    @SerializedName("title")
    val title: String,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("artist")
    val artist: String,
    @SerializedName("published")
    val published: String,
    @SerializedName("genre")
    val genre: String,
    @SerializedName("tracks")
    val tracks: List<Track>
)


