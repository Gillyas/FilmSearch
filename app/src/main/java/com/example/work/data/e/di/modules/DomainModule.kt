package com.example.work.data.e.di.modules

import com.example.work.data.e.MainRepository
import com.example.work.data.e.TmdbApi
import com.example.work.domain.Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {
    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi) = Interactor(repo = repository, retrofitService = tmdbApi)
}