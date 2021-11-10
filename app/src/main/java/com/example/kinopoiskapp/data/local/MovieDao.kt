package com.example.kinopoiskapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kinopoiskapp.data.local.model.GenreEntity
import com.example.kinopoiskapp.data.local.model.MovieEntity

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies")
    fun getAllMovies()

    @Query("SELECT * FROM movies WHERE id LIKE :genre")
    fun getMoviesByGenre(genre: GenreEntity)

    @Insert
    fun insertAllMovies(vararg movies: MovieEntity)
}