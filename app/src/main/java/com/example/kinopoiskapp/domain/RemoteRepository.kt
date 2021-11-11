package com.example.kinopoiskapp.domain

import com.example.kinopoiskapp.data.remote.OnLoadListener
import com.example.kinopoiskapp.data.remote.model.MoviesResponseDTO
import com.example.kinopoiskapp.domain.model.Movie

interface RemoteRepository {

    fun fetchAllMovies(onLoadListener: OnLoadListener<List<Movie>>)
}