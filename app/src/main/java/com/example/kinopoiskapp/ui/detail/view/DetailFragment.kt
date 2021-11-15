package com.example.kinopoiskapp.ui.detail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.kinopoiskapp.databinding.FragmentDetailBinding
import com.example.kinopoiskapp.databinding.FragmentMoviesBinding
import com.example.kinopoiskapp.domain.model.Movie
import com.example.kinopoiskapp.ui.detail.presenter.DetailsPresenter
import org.koin.android.ext.android.inject

class DetailFragment : Fragment(), DetailView {


    private val presenter: DetailsPresenter by inject()
    private val args: DetailFragmentArgs by navArgs()

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onAttachView(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.getMovieById(args.movieId)
    }

    override fun showMovieDetails(movie: Movie) {
        binding.apply {
            Glide.with(requireView())
                .load(movie.movieImageUri)
                .into(movieImageIv)

            toolbar.title = movie.movieName
            movieNameTv.text = movie.movieName
            movieYearTv.append(movie.movieYear.toString())
            movieRatingTv.append(movie.movieRating.toString())
            movieDescriptionTv.text = movie.movieDescriptor
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.onDetachView()
        _binding = null
    }
}