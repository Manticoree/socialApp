package com.app.socialapp.mvvm.topmovies


import android.os.Bundle
import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.socialapp.R
import com.app.socialapp.adapter.defaultadapter.MultiTopMoviesAdapter
import com.app.socialapp.data.entities.ItemManyHolderTopMovies
import com.app.socialapp.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_list_movies_tmdb.*

class TopMoviesFragment : BaseFragment(R.layout.fragment_list_movies_tmdb), LifecycleOwner {

    private lateinit var viewModel: TopMoviesViewModel
    private lateinit var tmdbAdapter: MultiTopMoviesAdapter

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
        viewModel.moviesLiveData.observe(viewLifecycleOwner, moviesList)
    }

    private var moviesList: Observer<List<ItemManyHolderTopMovies>> = Observer {
        showRecyclerView(it)
    }

    private fun showRecyclerView(initList: List<ItemManyHolderTopMovies>) {
        rvListSource.setHasFixedSize(true)
        val manager: RecyclerView.LayoutManager = LinearLayoutManager(
                activity,
                LinearLayoutManager.VERTICAL,
                false
        )
        rvListSource.layoutManager = manager
        tmdbAdapter = MultiTopMoviesAdapter(initList)
        rvListSource.adapter = tmdbAdapter
    }

}