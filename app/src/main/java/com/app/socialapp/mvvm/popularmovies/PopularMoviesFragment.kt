package com.app.socialapp.mvvm.popularmovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import com.app.socialapp.R
import com.app.socialapp.binding.viewBinding
import com.app.socialapp.databinding.FragmentPopularMoviesBinding
import com.app.socialapp.fragment.BaseFragment

class PopularMoviesFragment : BaseFragment(R.layout.fragment_popular_movies) {

    private val binding by viewBinding(FragmentPopularMoviesBinding::bind)
    private lateinit var viewModel: PopularMoviesViewModel
    private lateinit var navController: NavController

    companion object {
        private const val ARG_PAGE: String = "ARG_PAGE"
        fun newInstance(page: Int): PopularMoviesFragment {
            val args = Bundle()
            args.putInt(ARG_PAGE, page)
            val fragment = PopularMoviesFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PopularMoviesViewModel::class.java)

    }
}