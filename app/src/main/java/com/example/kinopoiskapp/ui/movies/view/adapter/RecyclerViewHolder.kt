package com.example.kinopoiskapp.ui.movies.view.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.kinopoiskapp.R
import com.example.kinopoiskapp.databinding.GenreItemLayoutBinding
import com.example.kinopoiskapp.databinding.MovieItemLayoutBinding
import com.example.kinopoiskapp.databinding.TitleItemLayoutBinding

sealed class RecyclerViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    var itemClickListener: ((item: RecyclerViewItem) -> Unit)? = null

    class TitleViewHolder(private val binding: TitleItemLayoutBinding) :
        RecyclerViewHolder(binding) {
        fun bind(title: RecyclerViewItem.Title) {
            binding.titleTv.text = title.title
        }
    }

    class GenreViewHolder(private val binding: GenreItemLayoutBinding) :
        RecyclerViewHolder(binding) {
        fun bind(genre: RecyclerViewItem.Genre) {
            binding.genreTitle.text = genre.title
        }
    }

    class MovieViewHolder(private val binding: MovieItemLayoutBinding) :
        RecyclerViewHolder(binding) {
        fun bind(movie: RecyclerViewItem.Movie) {
            binding.apply {
                movieTitleIv.text = movie.title
                Glide
                    .with(binding.root)
                    .load(movie.imageUrl)
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(movieImageIv)

                root.setOnClickListener {
                    itemClickListener?.invoke(movie)
                }
            }
        }
    }
}