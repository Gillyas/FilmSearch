package com.example.work.data.e.dao.db



import androidx.room.Database
import androidx.room.RoomDatabase

import com.example.work.data.e.Enity.Film
import com.example.work.data.e.dao.FilmDao

@Database(entities = [Film::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao
}
//
//entities — какие таблицы будут в БД;
//version — версию БД, это нужно для миграций;
//exportSchema — это для контроля версий, чтобы видеть, какая структура была в каждой версии БД.
//Мы такую функцию отключили, но вам рекомендуем подключить — о том, как это сделать, было сказано в скринкасте «Инициализация БД + exportSchema» ранее.