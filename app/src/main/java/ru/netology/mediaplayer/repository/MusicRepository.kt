package ru.netology.mediaplayer.repository

import ru.netology.mediaplayer.model.Music

interface MusicRepository {
    suspend fun getTracks( ) : Music

}