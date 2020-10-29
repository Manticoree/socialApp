package com.app.socialapp.mvvm.inyear


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.socialapp.R
import com.app.socialapp.adapter.TopMoviesTmdbAdapter
import com.app.socialapp.fragment.BaseFragment
import eu.davidea.flexibleadapter.FlexibleAdapter
import kotlinx.android.synthetic.main.fragment_list_movies_tmdb.*

class TopMoviesFragment : BaseFragment(), LifecycleOwner {

    private lateinit var viewModel: TopMoviesViewModel
    private var tmdbAdapter: FlexibleAdapter<TopMoviesTmdbAdapter>? = null

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

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.item_list_top_movie_in_year, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TopMoviesViewModel::class.java)
        viewModel.moviesLiveData.observe(viewLifecycleOwner, moviesList)
    }

    private var moviesList: Observer<List<TopMoviesTmdbAdapter>> = Observer {
        showRecyclerView(it)
    }

    private fun showRecyclerView(initList: List<TopMoviesTmdbAdapter>) {
        Log.i("initList: ", initList.toString())
        rvListSource.setHasFixedSize(true)
        val manager: RecyclerView.LayoutManager = LinearLayoutManager(
                activity,
                LinearLayoutManager.VERTICAL,
                false
        )
        rvListSource.layoutManager = manager
        tmdbAdapter = FlexibleAdapter(initList)
        rvListSource.adapter = tmdbAdapter
    }

}