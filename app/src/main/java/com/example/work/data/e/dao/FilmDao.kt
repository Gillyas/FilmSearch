package com.example.work.data.e.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.work.data.e.Enity.Film

//Помечаем, что это не просто интерфейс, а Dao-объект
@Dao
interface FilmDao {
    //Запрос на всю таблицу
    //Теперь мы получаем не список фильмов, а объект LiveData
    @Query("SELECT * FROM cached_films")
    fun gerCachedFilms(): LiveData<List<Film>>

    //Кладём списком в БД, в случае конфликта перезаписываем
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Film>)

}