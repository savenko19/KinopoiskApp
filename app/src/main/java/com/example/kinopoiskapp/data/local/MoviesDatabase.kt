package com.example.kinopoiskapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.kinopoiskapp.data.local.model.MovieEntity

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
@TypeConverters(GenresConverter::class)
abstract class MoviesDatabase: RoomDatabase() {
    abstract val movieDao: MovieDao
}