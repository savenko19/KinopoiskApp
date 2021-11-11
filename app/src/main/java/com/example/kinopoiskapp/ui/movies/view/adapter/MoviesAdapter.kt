package com.example.kinopoiskapp.ui.movies.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kinopoiskapp.R
import com.example.kinopoiskapp.databinding.MovieItemLayoutBinding
import com.example.kinopoiskapp.domain.model.Movie

class MoviesAdapter(
    private val onMovieClick: (movie: Movie) -> Unit,
    private val movies: List<Movie>
) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            MovieItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount() = movies.size

    inner class ViewHolder(private val binding: MovieItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.apply {
                movieTitleIv.text = movie.movieName

                Glide
                    .with(binding.root)
                    .load(movie.movieImageUri)
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(movieImageIv)

                root.setOnClickListener {
                    onMovieClick(movie)
                }
            }
        }

    }
}