package com.example.kinopoiskapp.ui.movies.view

import android.os.Bundle
import android.view.View
import com.example.kinopoiskapp.base.BaseFragment
import com.example.kinopoiskapp.data.remote.RemoteDataSource
import com.example.kinopoiskapp.databinding.FragmentMoviesBinding
import com.example.kinopoiskapp.ui.movies.presenter.MoviesPresenter
import org.koin.android.ext.android.inject

class MoviesFragment : BaseFragment<FragmentMoviesBinding>(
    FragmentMoviesBinding::inflate
), MoviesView {

    private val presenter: MoviesPresenter by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
    }

    override fun onResume() {
        super.onResume()
        presenter.viewIsReady()
    }

    private fun initView() {

    }
}