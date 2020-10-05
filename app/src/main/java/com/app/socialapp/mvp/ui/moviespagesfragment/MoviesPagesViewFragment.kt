package com.app.socialapp.mvp.ui.moviespagesfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.app.socialapp.R
import com.app.socialapp.application.MainApplication
import com.app.socialapp.fragment.BaseFragment
import com.app.socialapp.mvp.fragmentadapter.AdapterSocial
import com.app.socialapp.mvp.ui.searchfragment.SearchViewFragment
import com.jakewharton.rxbinding4.view.clicks

import kotlinx.android.synthetic.main.fragment_movies.*

class MoviesPagesViewFragment : BaseFragment(), MoviesPagesContract.View {

    var presenter: MoviesPagesContract.Presenter? = null
    var adapter: AdapterSocial? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainApplication.applicationComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_movies, container, false)
        if (presenter == null)
            presenter = MoviesPagesPresenter(this)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.onGoToTheSearchView()
    }

    override fun onResume() {
        super.onResume()
        presenter?.onShowMoviesFragment()
    }


    override fun showMoviesFragment() {
        if (adapter == null)
            adapter = AdapterSocial(requireActivity().supportFragmentManager, 1)
        vpSocial.adapter = adapter
        tabDiffSocial.setupWithViewPager(vpSocial)
    }

    override fun goToTheSearchView() {
        fabAddMovies.clicks().subscribe {
            presenter?.onShowSearchFragment()
        }
    }

    override fun showSearchFragment() {
        var fTransaction: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
        fTransaction.replace(R.id.fcvFragment, SearchViewFragment())
        fTransaction.commit()
    }
}