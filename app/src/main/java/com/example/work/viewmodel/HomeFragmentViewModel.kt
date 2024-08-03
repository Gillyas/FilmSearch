package com.example.work.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.work.App
import com.example.work.domain.Film
import com.example.work.domain.Interactor

class HomeFragmentViewModel: ViewModel() {
    val filmsListLiveData = MutableLiveData<List<Film>>()
    private var interactor: Interactor = App.instance.interactor
    init{
      val films = interactor.getFilmDB()
      filmsListLiveData.postValue(films)
    }
}