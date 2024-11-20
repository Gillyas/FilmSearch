package com.example.work.domain

import com.example.work.data.MainRepository

class Interactor(val repo: MainRepository) {
    fun getFilmDB(): List<Film> = repo.filmsDataBase
}