package com.example.kinopoiskapp.data

import android.util.Log
import androidx.room.util.StringUtil
import com.example.kinopoiskapp.data.local.MovieDao
import com.example.kinopoiskapp.data.local.model.MovieEntity
import com.example.kinopoiskapp.data.remote.OnLoadListener
import com.example.kinopoiskapp.data.remote.RemoteDataSource
import com.example.kinopoiskapp.data.remote.model.MovieDTO
import com.example.kinopoiskapp.data.remote.model.MoviesResponseDTO
import com.example.kinopoiskapp.di.repositoryModule
import com.example.kinopoiskapp.domain.Repository
import com.example.kinopoiskapp.domain.model.Movie

class RepositoryImpl(
    private val movieDao: MovieDao,
    private val remoteDataSource: RemoteDataSource
) : Repository {

    override fun getAllMovies(onLoadListener: OnLoadListener<List<Movie>>) {
        val movies = movieDao.getAllMovies().let { list ->
            list.map { movieEntity ->
                movieEntity.toUI()
            }
        }

        movies.let {
            if (it.isNotEmpty()) {
                onLoadListener.onLoadSuccess(it)
            } else {
                remoteDataSource.fetchAllMovies(object : OnLoadListener<MoviesResponseDTO> {
                    override fun onLoadSuccess(response: MoviesResponseDTO) {
                        val movies = response.let { moviesResponse ->
                            Log.e("Test", "MOVIES: ${moviesResponse.movies}")
                            moviesResponse.movies.map { movieDTO ->
                                movieDTO.toUI()
                            }
                        }

                        val moviesEntity = movies
                            .map { movie ->
                                movie.toEntity()
                            }


                        movieDao.insertAllMovies(moviesEntity)
                        onLoadListener.onLoadSuccess(movies)
                    }

                    override fun onLoadFailure(errorMsg: String) {
                        onLoadListener.onLoadFailure(errorMsg)
                    }
                })
            }
        }
    }

    override fun getMovieById(id: Int) =
        movieDao.getMovieById(id).toUI()

    override fun getMoviesByGenre(genre: String): List<Movie> {
        return movieDao.getMoviesByGenre(genre).map {
            it.toUI()
        }
    }

    override fun getGenres(): List<String> {
        val genres = HashSet<String>()
        movieDao.getAllMovies().forEach { movie ->
            movie.genres.forEach {
                if (it.isNotEmpty()) {
                    genres.add(it)
                }
            }
        }

        return ArrayList(genres)
    }
}

private fun MovieEntity.toUI() = Movie(
    id = this.id,
    movieName = this.name,
    movieImageUri = this.imageUrl,
    movieYear = this.year,
    genres = this.genres ?: ArrayList(),
    movieRating = this.rating,
    movieDescriptor = this.description
)

private fun MovieDTO.toUI() =
    Movie(
        this.id,
        this.movieLocalizedName,
        this.movieImageUrl,
        this.movieYear,
        this.genres,
        this.movieRating,
        this.movieDescription
    )

private fun Movie.toEntity() = MovieEntity(
    this.id,
    this.movieName,
    this.movieImageUri,
    this.genres,
    this.movieDescriptor,
    this.movieRating,
    this.movieYear
)
