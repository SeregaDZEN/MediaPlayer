package ru.netology.mediaplayer.repository

import kotlinx.coroutines.flow.Flow

interface MusicRepository {
    suspend fun getTrack( url : String)

}