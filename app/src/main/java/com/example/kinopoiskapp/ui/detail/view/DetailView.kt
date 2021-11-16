package com.example.kinopoiskapp.ui.detail.view

import com.example.kinopoiskapp.base.BaseView
import com.example.kinopoiskapp.domain.model.Movie

interface DetailView : BaseView {

    fun showMovieDetails(movie: Movie)
}