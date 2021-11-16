package com.example.kinopoiskapp.ui.movies.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kinopoiskapp.R
import com.example.kinopoiskapp.databinding.FragmentMoviesBinding
import com.example.kinopoiskapp.ui.movies.presenter.MoviesPresenter
import org.koin.android.ext.android.inject
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup

import androidx.recyclerview.widget.GridLayoutManager
import com.example.kinopoiskapp.ui.movies.view.adapter.MovieRecyclerViewAdapter
import com.example.kinopoiskapp.ui.movies.view.adapter.RecyclerViewItem


class MoviesFragment : Fragment(), MoviesView {

    private val presenter: MoviesPresenter by inject()

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!

    private val recyclerViewAdapter = MovieRecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttachView(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.viewIsReady()
    }


    override fun showMovies(movies: List<RecyclerViewItem>) {
        val manager = GridLayoutManager(requireContext(), 2)
        manager.spanSizeLookup = object : SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (recyclerViewAdapter.getItemViewType(position) == R.layout.movie_item_layout) 1 else 2
            }
        }

        recyclerViewAdapter.items = movies
        recyclerViewAdapter.itemClickListener = { recyclerViewItem ->
            when (recyclerViewItem) {
                is RecyclerViewItem.Movie -> {
                    Log.e("Test", "Click ${recyclerViewItem.title}")
                    val action = MoviesFragmentDirections.actionMoviesFragmentToDetailFragment(
                        recyclerViewItem.id
                    )
                    findNavController().navigate(action)
                }
                is RecyclerViewItem.Genre -> {
                    Log.e("Test", "Click ${recyclerViewItem.title}")
                    presenter.getMoviesByGenre(recyclerViewItem.title)
                }
            }
        }
        binding.moviesRecycler.apply {
            adapter = recyclerViewAdapter
            layoutManager = manager
        }
    }

    override fun showGenres() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        presenter.onDetachView()
    }
}