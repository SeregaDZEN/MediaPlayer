package ru.netology.mediaplayer.dto

data class Music(
    val id: Long,
    val title: String,
    val subtitle: String,
    val artist: String,
    val published: List<Int>,
    val genre: String,
    val tracks: List<Track>
)

data class Track(
    val id: Long,
    val file: String,
    val albumName: String,
    val name: String,
)
