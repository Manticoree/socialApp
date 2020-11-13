package com.app.socialapp.mvvm.topmoviefullinform

import android.os.Bundle
import android.view.View
import com.app.socialapp.R
import com.app.socialapp.binding.viewBinding
import com.app.socialapp.data.entities.tmdb.ItemMovie
import com.app.socialapp.databinding.FragmentFullInformationTopMovieBinding
import com.app.socialapp.fragment.BaseFragment

class FullInformationFragment : BaseFragment(R.layout.fragment_full_information_top_movie) {
    private val binding by viewBinding(FragmentFullInformationTopMovieBinding::bind)

    private lateinit var itemMovie: ItemMovie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val safeArgs = FullInformationFragmentArgs.fromBundle(
                    it
            )
            itemMovie = safeArgs.itemMovie
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            itemFullInformation = itemMovie
            lifecycleOwner = this@FullInformationFragment
        }
    }

}