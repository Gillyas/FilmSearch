package com.example.work.data.e.di.modules

import android.content.Context
import androidx.room.Room
import com.example.work.data.e.MainRepository
import com.example.work.data.e.dao.db.AppDatabase
import com.example.work.data.e.dao.FilmDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideFilmDao(context: Context) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "film_db"
    ).build().filmDao()

    @Provides
    @Singleton
    fun provideRepository(filmDao: FilmDao) = MainRepository(filmDao)
}