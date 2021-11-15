package com.example.kinopoiskapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kinopoiskapp.data.local.model.MovieEntity

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies")
    fun getAllMovies(): List<MovieEntity>

    @Query("SELECT * FROM movies WHERE id = :id")
    fun getMovieById(id: Int): MovieEntity

    @Insert
    fun insertAllMovies(movies: List<MovieEntity>)
}