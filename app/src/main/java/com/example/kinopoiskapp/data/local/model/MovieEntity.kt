package com.example.kinopoiskapp.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.kinopoiskapp.data.local.GenresConverter

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey
    val id: Int?,
    val name: String?,
    val imageUrl: String?,
    val genres: List<String>,
    val description: String?,
    val rating: Float?,
    val year: Int
)