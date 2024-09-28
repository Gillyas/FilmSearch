package com.example.work.data.e


import androidx.lifecycle.LiveData
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
//ViewModel теперь этот метод будет вызываться один раз, чтобы взять ссылку на этот объект
    fun getAllFromDB(): LiveData<List<Film>> = filmDao.gerCachedFilms()

}