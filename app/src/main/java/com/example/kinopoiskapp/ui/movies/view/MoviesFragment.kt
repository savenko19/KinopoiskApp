package com.example.kinopoiskapp.ui.movies.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kinopoiskapp.R
import com.example.kinopoiskapp.data.remote.model.MovieDTO
import com.example.kinopoiskapp.databinding.FragmentMoviesBinding
import com.example.kinopoiskapp.domain.model.Movie
import com.example.kinopoiskapp.ui.movies.presenter.MoviesPresenter
import com.example.kinopoiskapp.ui.movies.view.adapter.MoviesAdapter
import org.koin.android.ext.android.inject

class MoviesFragment : Fragment(), MoviesView {

    private val presenter: MoviesPresenter by inject()

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!

    private lateinit var moviesAdapter: MoviesAdapter

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


    override fun showMovies(movies: List<Movie>) {
        moviesAdapter = MoviesAdapter({
            findNavController().navigate(R.id.action_moviesFragment_to_detailFragment)
        }, movies)
        binding.moviesRecycler.adapter = moviesAdapter
    }

    override fun showGenres() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        presenter.onDetachView()
    }
}