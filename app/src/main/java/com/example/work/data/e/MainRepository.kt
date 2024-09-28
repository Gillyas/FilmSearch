package com.example.work.data.e


import com.example.work.data.e.dp.DatabaseHelper
import com.example.work.data.e.Enity.Film
import com.example.work.data.e.dao.FilmDao
import java.util.concurrent.Executors

class MainRepository(private val filmDao: FilmDao) {

    fun putToDb(films: List<Film>) {
        //Запросы в БД должны быть в отдельном потоке
        Executors.newSingleThreadExecutor().execute {
            filmDao.insertAll(films)
        }
    }

    fun getAllFromDB(): List<Film> {
        return filmDao.gerCachedFilms()
    }
}