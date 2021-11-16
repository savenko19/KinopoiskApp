package com.example.kinopoiskapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class MoviesResponseDTO(
    @SerializedName("films")
    val movies: List<MovieDTO>
)