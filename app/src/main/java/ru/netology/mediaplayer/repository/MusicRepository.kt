package ru.netology.mediaplayer.repository

import kotlinx.coroutines.flow.Flow

interface MusicRepository {
    suspend fun refreshHide()

    suspend fun showAll()



    fun getNewerCount(id: Long): Flow<Long>
}