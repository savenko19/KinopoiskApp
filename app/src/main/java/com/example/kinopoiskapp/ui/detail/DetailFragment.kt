package com.example.kinopoiskapp.ui.detail

import android.os.Bundle
import android.view.View
import com.example.kinopoiskapp.base.BaseFragment
import com.example.kinopoiskapp.base.BaseView
import com.example.kinopoiskapp.databinding.FragmentDetailBinding

class DetailFragment: BaseFragment<FragmentDetailBinding>(
    FragmentDetailBinding::inflate
), BaseView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {

    }
}