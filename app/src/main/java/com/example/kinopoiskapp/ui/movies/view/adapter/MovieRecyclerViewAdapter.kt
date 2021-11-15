package com.example.kinopoiskapp.ui.movies.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kinopoiskapp.R
import com.example.kinopoiskapp.databinding.GenreItemLayoutBinding
import com.example.kinopoiskapp.databinding.MovieItemLayoutBinding
import com.example.kinopoiskapp.databinding.TitleItemLayoutBinding

class MovieRecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewHolder>() {

    var items = listOf<RecyclerViewItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var itemClickListener: ((item: RecyclerViewItem) -> Unit)? = null

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is RecyclerViewItem.Title -> R.layout.title_item_layout
            is RecyclerViewItem.Movie -> R.layout.movie_item_layout
            is RecyclerViewItem.Genre -> R.layout.genre_item_layout
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return when (viewType) {
            R.layout.title_item_layout -> RecyclerViewHolder.TitleViewHolder(
                TitleItemLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            R.layout.movie_item_layout -> RecyclerViewHolder.MovieViewHolder(
                MovieItemLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            R.layout.genre_item_layout -> RecyclerViewHolder.GenreViewHolder(
                GenreItemLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            else -> throw IllegalAccessException()
        }
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        when (holder) {
            is RecyclerViewHolder.TitleViewHolder -> holder.bind(items[position] as RecyclerViewItem.Title)
            is RecyclerViewHolder.MovieViewHolder -> {
                holder.bind(items[position] as RecyclerViewItem.Movie)
                holder.itemClickListener = itemClickListener
            }
            is RecyclerViewHolder.GenreViewHolder -> holder.bind(items[position] as RecyclerViewItem.Genre)
        }
    }

    override fun getItemCount() = items.size
}