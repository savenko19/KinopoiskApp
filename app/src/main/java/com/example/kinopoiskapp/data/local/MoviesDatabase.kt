package com.example.kinopoiskapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kinopoiskapp.data.local.model.GenreEntity
import com.example.kinopoiskapp.data.local.model.MovieEntity

@Database(entities = [MovieEntity::class, GenreEntity::class], version = 1)
abstract class MoviesDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
}