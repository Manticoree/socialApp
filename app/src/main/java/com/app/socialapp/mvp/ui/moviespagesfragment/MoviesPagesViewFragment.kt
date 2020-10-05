package com.app.socialapp.mvp.ui.moviespagesfragment

import android.os.Bundle
import android.util.Log
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
        Log.i("LifecycleFragment: ", "onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_movies, container, false)
        if (presenter == null)
            presenter = MoviesPagesPresenter(this)
        Log.i("LifecycleFragment: ", "onCreateView")
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.onGoToTheSearchView()
        Log.i("LifecycleFragment: ", "onViewCreated")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("LifecycleFragment: ", "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.i("LifecycleFragment: ", "onStart")
    }

    override fun onResume() {
        super.onResume()
        presenter?.onShowMoviesFragment()
        Log.i("LifecycleFragment: ", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("LifecycleFragment: ", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("LifecycleFragment: ", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("LifecycleFragment: ", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LifecycleFragment: ", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("LifecycleFragment: ", "onDetach")
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