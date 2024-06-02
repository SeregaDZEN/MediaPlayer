package ru.netology.mediaplayer.repository

import android.content.Context
import retrofit2.HttpException
import ru.netology.mediaplayer.api.ApiService
import ru.netology.mediaplayer.api.RetrofitService
import ru.netology.mediaplayer.model.Music
import ru.netology.mediaplayer.error.ApiError
import ru.netology.mediaplayer.error.NetworkError
import java.io.IOException
import javax.inject.Inject


class MusicRepositoryImpl @Inject constructor(private val api: ApiService) : MusicRepository {

    override suspend fun getTracks(): Music {

        return try {
            api.getTracks() // Прямой вызов, который может выбросить исключение
        } catch (e: HttpException) {
            throw ApiError(e.code(), e.message()) // Преобразование в ваше кастомное исключение
        } catch (e: IOException) {
            throw NetworkError // Сетевая ошибка
        }
    }
}


