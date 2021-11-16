package com.example.kinopoiskapp.di

import com.example.kinopoiskapp.domain.Repository
import com.example.kinopoiskapp.ui.detail.presenter.DetailsPresenter
import com.example.kinopoiskapp.ui.detail.presenter.DetailsPresenterImpl
import com.example.kinopoiskapp.ui.movies.presenter.MoviesPresenter
import com.example.kinopoiskapp.ui.movies.presenter.MoviesPresenterImpl
import org.koin.dsl.module

val appModule = module {
    single { provideMoviesPresenter(repository = get()) }
    single { provideDetailsPresenter(repository = get()) }
}

private fun provideMoviesPresenter(
    repository: Repository
): MoviesPresenter {
    return MoviesPresenterImpl(repository)
}

private fun provideDetailsPresenter(
    repository: Repository
): DetailsPresenter {
    return DetailsPresenterImpl(repository)
}