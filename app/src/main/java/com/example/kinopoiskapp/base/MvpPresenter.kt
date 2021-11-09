package com.example.kinopoiskapp.base

interface MvpPresenter<V: BaseView> {

    fun onAttachView(view: V)

    fun onDetachView()
}