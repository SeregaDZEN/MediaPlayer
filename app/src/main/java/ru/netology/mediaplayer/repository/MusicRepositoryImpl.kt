package ru.netology.mediaplayer.repository

import kotlinx.coroutines.flow.Flow

class MusicRepositoryImpl : MusicRepository {
    override suspend fun refreshHide() {
        TODO("Not yet implemented")
    }

    override suspend fun showAll() {
        TODO("Not yet implemented")
    }

    override fun getNewerCount(id: Long): Flow<Long> {
        TODO("Not yet implemented")
    }
}