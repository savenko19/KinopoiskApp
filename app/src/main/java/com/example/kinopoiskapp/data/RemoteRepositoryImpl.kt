package com.example.kinopoiskapp.data

import com.example.kinopoiskapp.data.remote.OnLoadListener
import com.example.kinopoiskapp.data.remote.RemoteDataSource
import com.example.kinopoiskapp.data.remote.model.MoviesResponseDTO
import com.example.kinopoiskapp.domain.RemoteRepository

class RemoteRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
): RemoteRepository {

    override fun fetchAllMovies(onLoadListener: OnLoadListener<MoviesResponseDTO>) {
        remoteDataSource.fetchAllMovies(onLoadListener)
    }
}