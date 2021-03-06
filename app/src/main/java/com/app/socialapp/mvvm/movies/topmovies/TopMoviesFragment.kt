package com.app.socialapp.mvvm.movies.topmovies


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.app.socialapp.R
import com.app.socialapp.adapter.defaultadapter.MultiTopMoviesAdapter
import com.app.socialapp.binding.viewBinding
import com.app.socialapp.databinding.FragmentListMoviesTmdbBinding
import com.app.socialapp.fragment.BaseFragment

class TopMoviesFragment : BaseFragment(R.layout.fragment_list_movies_tmdb), LifecycleOwner {

    private val binding by viewBinding(FragmentListMoviesTmdbBinding::bind)
    private lateinit var viewModel: TopMoviesViewModel
    private lateinit var navController: NavController

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
        Log.i("onViewCreated: ", "")

        viewModel = ViewModelProviders.of(this).get(TopMoviesViewModel::class.java)
        navController = Navigation.findNavController(view)
        binding.apply {
            lifecycleOwner = this@TopMoviesFragment
            vmListTopMovies = if (viewModel.moviesLiveData.value.isNullOrEmpty()) {
                viewModel.apply { viewModel.loadDataInRecView() }
            } else {
                viewModel.apply { viewModel.moviesLiveData.value }
            }
            adapterMultiTopMovies = MultiTopMoviesAdapter()
        }
    }

    override fun onStop() {
        Log.i("lifeCycleOnStop: ", "")
        super.onStop()
    }

    override fun onDestroy() {
        Log.i("lifeCycleOnDestroy: ", "")
        super.onDestroy()
    }
}