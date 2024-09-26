package ru.netology.mediaplayer.repository

import ru.netology.mediaplayer.api.ApiService
import ru.netology.mediaplayer.error.AppError
import ru.netology.mediaplayer.model.Music
import javax.inject.Inject


class MusicRepositoryImpl @Inject constructor(private val api: ApiService) : MusicRepository {

    override suspend fun getTracks(): Music {

        return try {
            api.getTracks() // Прямой вызов, который может выбросить исключение
        } catch (e: Throwable) {
            throw AppError.from(e) // Преобразование в ваше кастомное исключение
        }
    }
}


