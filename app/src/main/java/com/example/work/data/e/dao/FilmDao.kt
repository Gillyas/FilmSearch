package com.example.work.data.e.dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.work.data.e.Enity.Film
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer

//Помечаем, что это не просто интерфейс а Dao объект
@Dao
interface FilmDao {
    //Запрос на всю таблицу
    @Query("SELECT * FROM cached_films")
    fun getCachedFilms(): Observable<List<Film>>


    //Кладем списком в БД, в случае конфликта, перезаписываем
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Film>)
}