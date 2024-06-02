package ru.netology.mediaplayer.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.netology.mediaplayer.api.ApiService
import ru.netology.mediaplayer.api.RetrofitService
import ru.netology.mediaplayer.repository.MusicRepository
import ru.netology.mediaplayer.repository.MusicRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)

abstract class AppModuleBinding {
    @Binds
    abstract fun bindMusicRepository(
        impl: MusicRepositoryImpl
    ): MusicRepository

}

@Module
@InstallIn(SingletonComponent::class)
 class AppModule {

    @Provides
    fun apiProvides(): ApiService {
        return RetrofitService.apiService
    }

}