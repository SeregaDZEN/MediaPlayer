package ru.netology.mediaplayer.viewmodel

import ru.netology.mediaplayer.model.Track

data class TrackUiModel(
    val file : String,
    val playing : Boolean = false
){
    companion object{
        fun fromModel ( track: Track) = TrackUiModel(file = track.file)
    }
}
