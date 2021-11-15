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

    override fun viewIsReady() {
        fetchAllMovies()
        view?.showGenres()
    }

    override fun fetchAllMovies() {
        repository.getAllMovies(object : OnLoadListener<List<Movie>> {
            override fun onLoadSuccess(response: List<Movie>) {
                val recyclerViewItems = mutableListOf<RecyclerViewItem>()
                recyclerViewItems.add(RecyclerViewItem.Title("Жанры"))
                recyclerViewItems.addAll(
                    listOf(
                        RecyclerViewItem.Genre(
                            "QWE"
                        ),
                        RecyclerViewItem.Genre(
                            "QWE"
                        ),
                        RecyclerViewItem.Genre(
                            "QWE"
                        ),
                        RecyclerViewItem.Genre(
                            "QWE"
                        )
                    )
                )
                recyclerViewItems.add(RecyclerViewItem.Title("Фильмы"))
                recyclerViewItems.addAll(response.map {
                    it.toRecyclerViewItem()
                })
                view?.showMovies(recyclerViewItems)
            }

            override fun onLoadFailure(errorMsg: String) {
                Log.e("Test", "ERROR: $errorMsg")
            }
        })
    }
}

private fun Movie.toRecyclerViewItem() = RecyclerViewItem.Movie(
    this.id!!,
    this.movieName!!,
    this.movieImageUri
)