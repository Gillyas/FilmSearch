package com.example.work


import android.app.Application

import com.example.work.data.e.di.modules.AppComponent
import com.example.work.data.e.di.modules.DaggerAppComponent


import com.example.work.data.e.di.modules.DatabaseModule
import com.example.work.data.e.di.modules.DomainModule
import com.example.work.data.e.di.modules.RemoteModule



class App : Application() {
    lateinit var dagger: AppComponent
    override fun onCreate() {

        super.onCreate()
        instance = this
        //Создаем компонент
        dagger = DaggerAppComponent.builder()
            .remoteModule(RemoteModule())
            .databaseModule(DatabaseModule())
            .domainModule(DomainModule(this))
            .build()
    }
    companion object {
        lateinit var instance: App
            private set
    }
}