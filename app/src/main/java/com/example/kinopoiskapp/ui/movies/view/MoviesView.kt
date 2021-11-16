package com.example.kinopoiskapp.ui.movies.view

import com.example.kinopoiskapp.base.BaseView
import com.example.kinopoiskapp.domain.model.Movie
import com.example.kinopoiskapp.ui.movies.view.adapter.RecyclerViewItem

interface MoviesView : BaseView {

    fun showMovies(movies: List<RecyclerViewItem>)

    fun showGenres()
}