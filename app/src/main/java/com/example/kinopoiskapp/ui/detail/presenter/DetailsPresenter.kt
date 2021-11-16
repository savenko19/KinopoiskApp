package com.example.kinopoiskapp.ui.detail.presenter

import com.example.kinopoiskapp.base.MvpPresenter
import com.example.kinopoiskapp.ui.detail.view.DetailView

interface DetailsPresenter : MvpPresenter<DetailView> {

    fun getMovieById(id: Int)
}