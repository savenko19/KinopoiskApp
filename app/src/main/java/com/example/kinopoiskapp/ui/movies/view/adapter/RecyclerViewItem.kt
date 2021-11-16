package com.example.kinopoiskapp.ui.movies.view.adapter

sealed class RecyclerViewItem {
    class Title(
        val title: String
    ) : RecyclerViewItem()

    class Movie(
        val id: Int,
        val title: String,
        val imageUrl: String?
    ) : RecyclerViewItem()

    class Genre(
        val title: String
    ) : RecyclerViewItem()
}