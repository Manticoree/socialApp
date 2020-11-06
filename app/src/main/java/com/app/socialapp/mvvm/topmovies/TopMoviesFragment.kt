package com.app.socialapp.mvvm.topmovies


import android.os.Bundle
import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProviders
import com.app.socialapp.R
import com.app.socialapp.adapter.defaultadapter.MultiTopMoviesAdapter
import com.app.socialapp.binding.viewBinding
import com.app.socialapp.databinding.FragmentListMoviesTmdbBinding
import com.app.socialapp.fragment.BaseFragment

class TopMoviesFragment : BaseFragment(R.layout.fragment_list_movies_tmdb), LifecycleOwner {

    private val binding by viewBinding(FragmentListMoviesTmdbBinding::bind)
    private lateinit var viewModel: TopMoviesViewModel

    companion object {
        private const val ARG_PAGE: String = "ARG_PAGE"
        fun newInstance(page: Int): TopMoviesFragment {
            val args = Bundle()
            args.putInt(ARG_PAGE, page)
            val fragment = TopMoviesFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TopMoviesViewModel::class.java)
        binding.apply {
            lifecycleOwner = this@TopMoviesFragment
            adapterMultiTopMovies = MultiTopMoviesAdapter()
            vmListTopMovies = viewModel.apply { loadDataInRecView() }
        }
    }
}