package com.example.kinopoiskapp.data.remote

import com.example.kinopoiskapp.data.remote.model.MovieDTO
import com.example.kinopoiskapp.data.remote.model.MoviesResponseDTO

class RemoteDataSource(
    private val moviesApi: MoviesApi
) {

    fun fetchAllMovies(onLoadListener: OnLoadListener<MoviesResponseDTO>) {
        moviesApi.fetchMovies()
            .enqueue(RestCallback(object : OnLoadListener<MoviesResponseDTO> {
                override fun onLoadSuccess(response: MoviesResponseDTO) {
                    onLoadListener.onLoadSuccess(response)
                }

                override fun onLoadFailure(errorMsg: String) {

                }
            }))
    }
}