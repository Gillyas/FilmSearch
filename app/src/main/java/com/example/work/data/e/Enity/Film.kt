package com.example.work.data.e.Enity

import android.os.Parcelable

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "cached_films", indices = [Index(value = ["title"], unique = true)])
data class Film(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "poster_path") val poster: String,//У нас будет приходить ссылка на картинку, так что теперь это
    @ColumnInfo(name = "overview") val description: String,
    @ColumnInfo(name = "vote_average") val rating: Double = 0.0, //Приходит нецелое число с API
    var isInFavorites: Boolean = false
    ) : Parcelable