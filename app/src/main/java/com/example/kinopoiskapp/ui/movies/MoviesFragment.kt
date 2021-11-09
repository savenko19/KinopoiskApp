package com.example.kinopoiskapp.ui.movies

import android.os.Bundle
import android.view.View
import com.example.kinopoiskapp.base.BaseFragment
import com.example.kinopoiskapp.base.BaseView
import com.example.kinopoiskapp.databinding.FragmentMoviesBinding

class MoviesFragment : BaseFragment<FragmentMoviesBinding>(
    FragmentMoviesBinding::inflate
), BaseView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
    }

    private fun initView() {

    }
}