package com.example.work.data.e


import com.example.work.data.e.Enity.Film
import com.example.work.data.e.dao.FilmDao
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.flow.Flow

class MainRepository(private val filmDao: FilmDao) {

    fun putToDb(films: List<Film>) {
        filmDao.insertAll(films)

    }
        fun getAllFromDB(): Observable<List<Film>> = filmDao.getCachedFilms()

}