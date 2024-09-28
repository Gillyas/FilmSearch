package com.example.work.data.e.dp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(p0: SQLiteDatabase?) {
        // создаем саму таблицу для фильмов
        p0?.execSQL("CREATE TABLE $TABLE_NAME (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COLUMN_TITLE TEXT UNIQUE," +
                //столбец для ссылки на постер.
                "$COLUMN_POSTER TEXT," +
                //столбец для хранения описания.
                "$COLUMN_DESCRIPTION TEXT," +
                //столбец для рейтинга. Как помните, рейтинг у нас в Double,
                // поэтому мы создаем столбец с типом REAL.
                "$COLUMN_RATING REAL);")
    }
    //Миграций мы не предполагаем, поэтому метод пустой
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    companion object {
        // Название самой бд
        private const val DATABASE_NAME = "films.db"

        // Версия ДБ
        private const val DATABASE_VERSION = 1

        // Константы для работы с таблицей, они нам понадобятся с CRUD операциях и,
        // возможно, в составлении запросов

        const val TABLE_NAME = "films_table"
        const val COLUMN_ID = "id"
        const val COLUMN_TITLE = "title"
        const val COLUMN_POSTER = "poster_path"
        const val COLUMN_DESCRIPTION = "overview"
        const val COLUMN_RATING = "vote_average"


    }

}