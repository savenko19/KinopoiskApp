package com.example.kinopoiskapp.data.local

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import java.util.stream.Collectors

class GenresConverter {
    @RequiresApi(Build.VERSION_CODES.N)
    @TypeConverter
    fun fromGenres(genres: List<String>): String {
        return genres.stream().collect(Collectors.joining(","))
    }

    @TypeConverter
    fun toGenres(data: String): List<String> {
        return data.split(",")
    }
}