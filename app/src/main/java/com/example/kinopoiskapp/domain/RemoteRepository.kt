package com.example.kinopoiskapp.domain

import com.example.kinopoiskapp.data.remote.OnLoadListener
import com.example.kinopoiskapp.data.remote.model.MoviesResponseDTO

interface RemoteRepository {

    fun fetchAllMovies(onLoadListener: OnLoadListener<MoviesResponseDTO>)
}