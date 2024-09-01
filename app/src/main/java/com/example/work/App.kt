package com.example.work


import android.app.Application
import com.example.work.data.e.di.modules.AppComponent
import com.example.work.data.e.di.modules.DaggerAppComponent




class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        //Создаем компонент
        dagger = DaggerAppComponent.create()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}