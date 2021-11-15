package com.example.kinopoiskapp.domain

import com.example.kinopoiskapp.data.remote.OnLoadListener
import com.example.kinopoiskapp.domain.model.Movie

interface Repository {

    fun getAllMovies(onLoadListener: OnLoadListener<List<Movie>>)

    fun getMovieById(id: Int): Movie
}