package com.example.kinopoiskapp.ui.movies.presenter

import android.util.Log
import com.example.kinopoiskapp.base.BasePresenter
import com.example.kinopoiskapp.data.remote.OnLoadListener
import com.example.kinopoiskapp.domain.Repository
import com.example.kinopoiskapp.domain.model.Movie
import com.example.kinopoiskapp.ui.movies.view.MoviesView
import com.example.kinopoiskapp.ui.movies.view.adapter.RecyclerViewItem

class MoviesPresenterImpl(
    private val repository: Repository
) : BasePresenter<MoviesView>(), MoviesPresenter {

    private lateinit var movies: List<Movie>

    override fun viewIsReady() {
        fetchAllMovies()
    }

    override fun fetchAllMovies() {
        repository.getAllMovies(object : OnLoadListener<List<Movie>> {
            override fun onLoadSuccess(response: List<Movie>) {
                movies = response
                showMovies(movies)
            }

            override fun onLoadFailure(errorMsg: String) {
                Log.e("Test", "ERROR: $errorMsg")
            }
        })
    }

    override fun getMoviesByGenre(genre: String) {
        movies = repository.getMoviesByGenre(genre)
        showMovies(movies)
    }

    private fun showMovies(movies: List<Movie>) {
        val recyclerViewItems = mutableListOf<RecyclerViewItem>()
        recyclerViewItems.add(RecyclerViewItem.Title("Жанры"))
        recyclerViewItems.addAll(repository.getGenres().map {
            it.toRecyclerViewItem()
        })
        recyclerViewItems.add(RecyclerViewItem.Title("Фильмы"))
        recyclerViewItems.addAll(movies.map {
            it.toRecyclerViewItem()
        })
        view?.showMovies(recyclerViewItems)
    }
}

private fun String.toRecyclerViewItem() = RecyclerViewItem.Genre(
    title = this
)

private fun Movie.toRecyclerViewItem() = RecyclerViewItem.Movie(
    this.id!!,
    this.movieName!!,
    this.movieImageUri
)