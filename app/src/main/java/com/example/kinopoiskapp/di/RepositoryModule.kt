package com.example.kinopoiskapp.di

import com.example.kinopoiskapp.data.LocalRepositoryImpl
import com.example.kinopoiskapp.data.RemoteRepositoryImpl
import com.example.kinopoiskapp.data.local.MovieDao
import com.example.kinopoiskapp.data.remote.RemoteDataSource
import com.example.kinopoiskapp.domain.LocalRepository
import com.example.kinopoiskapp.domain.RemoteRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { provideRemoteRepository(remoteDataSource = get()) }
    single { provideLocalRepository(movieDao = get()) }
}

private fun provideRemoteRepository(
    remoteDataSource: RemoteDataSource
): RemoteRepository {
    return RemoteRepositoryImpl(remoteDataSource)
}

private fun provideLocalRepository(
    movieDao: MovieDao
): LocalRepository {
    return LocalRepositoryImpl(movieDao)
}