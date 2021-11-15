package com.example.kinopoiskapp.di

import android.app.Application
import androidx.room.Room
import com.example.kinopoiskapp.data.local.MovieDao
import com.example.kinopoiskapp.data.local.MoviesDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val localModule = module {

    fun provideDatabase(application: Application): MoviesDatabase {
        return Room.databaseBuilder(application, MoviesDatabase::class.java, "MoviesDB")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    fun provideDao(database: MoviesDatabase): MovieDao =
        database.movieDao

    single { provideDatabase(androidApplication()) }
    single { provideDao(database = get()) }
}

