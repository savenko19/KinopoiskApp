package com.example.kinopoiskapp.ui.movies.view

import com.example.kinopoiskapp.base.BaseView
import com.example.kinopoiskapp.domain.model.Movie

interface MoviesView: BaseView {

    fun showMovies(movies: List<Movie>)

    fun showGenres()
}