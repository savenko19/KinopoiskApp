package com.example.kinopoiskapp.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "movies")
data class MovieEntity(
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String?
)