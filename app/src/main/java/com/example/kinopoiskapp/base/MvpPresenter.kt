package com.example.kinopoiskapp.base

interface MvpPresenter<V: BaseView> {

    fun viewIsReady()

    fun onAttachView(view: V)

    fun onDetachView()
}