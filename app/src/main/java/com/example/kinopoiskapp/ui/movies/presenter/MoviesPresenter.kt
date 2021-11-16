package com.example.kinopoiskapp.ui.movies.presenter

import com.example.kinopoiskapp.base.MvpPresenter
import com.example.kinopoiskapp.domain.model.Movie
import com.example.kinopoiskapp.ui.movies.view.MoviesView

interface MoviesPresenter: MvpPresenter<MoviesView> {

    fun fetchAllMovies()

    fun getMoviesByGenre(genre: String)
}