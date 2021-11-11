package com.example.kinopoiskapp.data

import com.example.kinopoiskapp.data.local.MovieDao
import com.example.kinopoiskapp.domain.LocalRepository

class LocalRepositoryImpl(
    private val movieDao: MovieDao
) : LocalRepository {

}