package com.example.kinopoiskapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class MovieDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("localized_name")
    val movieLocalizedName: String,
    @SerializedName("name")
    val movieName: String,
    @SerializedName("year")
    val movieYear: Int,
    @SerializedName("genres")
    val genres: ArrayList<String>,
    @SerializedName("rating")
    val movieRating: Float,
    @SerializedName("image_url")
    val movieImageUrl: String,
    @SerializedName("description")
    val movieDescription: String
)