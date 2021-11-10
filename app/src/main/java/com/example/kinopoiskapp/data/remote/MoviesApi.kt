package com.example.kinopoiskapp.data.remote

import com.example.kinopoiskapp.data.remote.model.MoviesResponseDTO
import retrofit2.Call
import retrofit2.http.GET

interface MoviesApi {
    @GET("films.json")
    fun fetchMovies(): Call<MoviesResponseDTO>
}