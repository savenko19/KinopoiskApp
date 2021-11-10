package com.example.kinopoiskapp.di

import com.example.kinopoiskapp.domain.RemoteRepository
import com.example.kinopoiskapp.ui.movies.presenter.MoviesPresenter
import com.example.kinopoiskapp.ui.movies.presenter.MoviesPresenterImpl
import org.koin.dsl.module

val appModule = module {
    single { provideMoviesPresenter(remoteRepository = get()) }
}

private fun provideMoviesPresenter(remoteRepository: RemoteRepository): MoviesPresenter {
    return MoviesPresenterImpl(remoteRepository)
}