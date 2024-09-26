package ru.netology.mediaplayer.error

import retrofit2.HttpException
import java.io.IOException
import java.sql.SQLException

sealed class AppError(var code: String, e: Throwable) : RuntimeException(e) {

    companion object {
        fun from(e: Throwable): AppError = when (e) {
            is AppError -> e
            is SQLException -> DbError(e)
            is IOException -> NetworkError(e)
            is HttpException -> HttpException(e)
            else -> UnknownError(e)
        }
    }
}

class ApiError(code: String, e: Exception) : AppError(code, e)
class NetworkError(e: Exception) : AppError("error_network", e)
class DbError(e: Exception) : AppError("error_DB", e)
class UnknownError(e: Throwable) : AppError("error_unknown", e)
class HttpException(e: Exception) : AppError("answer_server_unknown", e)