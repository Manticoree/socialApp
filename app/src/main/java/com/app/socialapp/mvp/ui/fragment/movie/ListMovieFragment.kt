package com.app.socialapp.mvp.ui.fragment.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.socialapp.R
import com.app.socialapp.adapter.MoviesImdbAdapter
import com.app.socialapp.fragment.BaseFragment
import eu.davidea.flexibleadapter.FlexibleAdapter
import kotlinx.android.synthetic.main.fragment_list_my_movies.*

class ListMovieFragment : BaseFragment(), ListMovieContract.View {

    private lateinit var presenter: ListMovieContract.Presenter
    private lateinit var imdbAdapter: FlexibleAdapter<MoviesImdbAdapter>

    companion object {
        private const val ARG_PAGE: String = "ARG_PAGE"
        fun newInstance(page: Int): ListMovieFragment {
            val args = Bundle()
            args.putInt(ARG_PAGE, page)
            val fragment = ListMovieFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_list_my_movies, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ListMoviePresenter(this)
        presenter.onShowRecyclerView()
    }

    override fun onDetach() {
        presenter.cleanMemory()
        super.onDetach()
    }

    override fun showRecyclerView(initList: List<MoviesImdbAdapter>) {
        Log.i("initList: ", initList.toString())
        rvListSource.setHasFixedSize(true)
        val manager: RecyclerView.LayoutManager = LinearLayoutManager(
                activity,
                LinearLayoutManager.VERTICAL,
                false
        )
        rvListSource.layoutManager = manager
        imdbAdapter = FlexibleAdapter(initList)
        rvListSource.adapter = imdbAdapter
    }

}


