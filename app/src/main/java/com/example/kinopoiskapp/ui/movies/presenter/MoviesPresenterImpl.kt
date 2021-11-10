package com.example.kinopoiskapp.ui.movies.presenter

import android.util.Log
import com.example.kinopoiskapp.base.BasePresenter
import com.example.kinopoiskapp.data.remote.OnLoadListener
import com.example.kinopoiskapp.data.remote.model.MovieDTO
import com.example.kinopoiskapp.data.remote.model.MoviesResponseDTO
import com.example.kinopoiskapp.domain.RemoteRepository
import com.example.kinopoiskapp.ui.movies.view.MoviesView

class MoviesPresenterImpl(
    private val remoteRepository: RemoteRepository
) : BasePresenter<MoviesView>(), MoviesPresenter {

    override fun viewIsReady() {
        fetchAllMovies()
    }

    override fun fetchAllMovies() {
        remoteRepository.fetchAllMovies(object : OnLoadListener<MoviesResponseDTO> {
            override fun onLoadSuccess(response: MoviesResponseDTO) {
                for (movie in response.movies) {
                    Log.e("Test", movie.movieLocalizedName)
                }
            }

            override fun onLoadFailure(errorMsg: String) {
                Log.e("Test", errorMsg)
            }
        })
    }
}