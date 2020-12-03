package com.app.socialapp.mvp.ui.fragment.movie

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.socialapp.R
import com.app.socialapp.adapter.flexadapter.MoviesImdbAdapter
import com.app.socialapp.fragment.BaseFragment
import com.jakewharton.rxbinding4.view.clicks
import eu.davidea.flexibleadapter.FlexibleAdapter
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_list_my_movies.*

class ListMovieFragment : BaseFragment(R.layout.fragment_list_my_movies), ListMovieContract.View {

    private lateinit var presenter: ListMovieContract.Presenter
    private lateinit var imdbAdapter: FlexibleAdapter<MoviesImdbAdapter>
    private lateinit var navController: NavController
    var disList: MutableList<Disposable> = mutableListOf()

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        presenter = ListMoviePresenter(this)
        presenter.onShowRecyclerView()
        presenter.onGoToTheSearchView()
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

    override fun goToTheSearchView() {
        disList.add(mBtnAddCategory.clicks().subscribe {
            presenter.onShowSearchFragment()
        })
    }

    override fun showSearchFragment() {
        navController.navigate(R.id.action_host_to_search)
    }

}


