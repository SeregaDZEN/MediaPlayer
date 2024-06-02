package ru.netology.mediaplayer.viewmodel


data class MusicState (
    val status: Status = Status.IDLE,
    val tracks: List<TrackUiModel> = emptyList(),
)



enum class Status {
    IDLE, ERROR, LOADING,
}