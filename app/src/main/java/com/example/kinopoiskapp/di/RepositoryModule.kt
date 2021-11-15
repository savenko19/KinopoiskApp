package com.example.kinopoiskapp.di

import com.example.kinopoiskapp.data.RepositoryImpl
import com.example.kinopoiskapp.data.local.MovieDao
import com.example.kinopoiskapp.data.remote.RemoteDataSource
import com.example.kinopoiskapp.domain.Repository
import org.koin.dsl.module

val repositoryModule = module {
    single { provideLocalRepository(movieDao = get(), remoteDataSource = get()) }
}

private fun provideLocalRepository(
    movieDao: MovieDao, remoteDataSource: RemoteDataSource
): Repository {
    return RepositoryImpl(movieDao, remoteDataSource)
}