package com.example.kinopoiskapp.domain.model

data class Movie(
    val id: Int,
    val movieName: String,
    val movieImageUri: String?,
    val movieYear: Int,
    val movieRating: Float,
    val movieDescriptor: String?,
)