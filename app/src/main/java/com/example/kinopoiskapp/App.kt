package com.example.kinopoiskapp

import android.app.Application
import com.example.kinopoiskapp.di.appModule
import com.example.kinopoiskapp.di.localModule
import com.example.kinopoiskapp.di.remoteModule
import com.example.kinopoiskapp.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(remoteModule, localModule, repositoryModule, appModule))
        }
    }
}