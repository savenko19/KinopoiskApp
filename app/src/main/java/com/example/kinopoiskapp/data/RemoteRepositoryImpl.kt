package com.example.kinopoiskapp.data

import com.example.kinopoiskapp.data.remote.OnLoadListener
import com.example.kinopoiskapp.data.remote.RemoteDataSource
import com.example.kinopoiskapp.data.remote.model.MovieDTO
import com.example.kinopoiskapp.data.remote.model.MoviesResponseDTO
import com.example.kinopoiskapp.domain.RemoteRepository
import com.example.kinopoiskapp.domain.model.Movie

class RemoteRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : RemoteRepository {

    override fun fetchAllMovies(onLoadListener: OnLoadListener<List<Movie>>) {
        remoteDataSource.fetchAllMovies(object : OnLoadListener<MoviesResponseDTO> {
            override fun onLoadSuccess(response: MoviesResponseDTO) {
                val movies = response.let {
                    it.movies.map { movieDTO ->
                        movieDTO.toUi()
                    }
                }
                onLoadListener.onLoadSuccess(movies)
            }

            override fun onLoadFailure(errorMsg: String) {
                TODO("Not yet implemented")
            }
        })
    }
}

private fun MovieDTO.toUi() =
    Movie(
        this.id,
        this.movieLocalizedName,
        this.movieImageUrl,
        this.movieYear,
        this.movieRating,
        this.movieDescription
    )