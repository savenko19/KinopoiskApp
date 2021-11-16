package com.example.kinopoiskapp.ui.detail.presenter

import com.example.kinopoiskapp.base.BasePresenter
import com.example.kinopoiskapp.domain.Repository
import com.example.kinopoiskapp.ui.detail.view.DetailView

class DetailsPresenterImpl(
    private val repository: Repository
) : BasePresenter<DetailView>(), DetailsPresenter {

    override fun viewIsReady() {

    }

    override fun getMovieById(id: Int) {
        view?.showMovieDetails(repository.getMovieById(id))
    }
}