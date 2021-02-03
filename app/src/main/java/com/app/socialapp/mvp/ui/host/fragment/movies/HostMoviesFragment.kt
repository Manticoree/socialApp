package com.app.socialapp.mvp.ui.host.fragment.movies

import android.os.Bundle
import android.util.Log
import android.view.View
import com.app.socialapp.R
import com.app.socialapp.fragment.BaseFragment
import com.app.socialapp.ui.fragmentadapter.AdapterMovieHost
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_movies_host.*

class HostMoviesFragment : BaseFragment(R.layout.fragment_movies_host), HostMoviesContract.View {

    lateinit var presenter: HostMoviesContract.Presenter
    lateinit var adapterMovie: AdapterMovieHost
    var disList: MutableList<Disposable> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("LifecycleFragmentInit: ", "onCreate")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.i("LifecycleFragmentInit: ", "onViewCreated")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("LifecycleFragmentInit: ", "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        presenter = HostMoviesPresenter(this)
        presenter.onShowMoviesFragment()
        Log.i("LifecycleFragmentInit: ", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("LifecycleFragmentInit: ", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("LifecycleFragmentInit: ", "onPause")
    }

    override fun onStop() {
        for (i in disList)
            i.dispose()
        super.onStop()
        Log.i("LifecycleFragmentInit: ", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("LifecycleFragmentInit: ", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LifecycleFragmentInit: ", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("LifecycleFragmentInit: ", "onDetach")
    }

    override fun showMoviesFragment() {
        Log.i("LifecycleFragmentInit: ", "showMovies")
        adapterMovie = AdapterMovieHost(childFragmentManager, 1)
        vpSocial.adapter = adapterMovie
        tabDiffSocial.setupWithViewPager(vpSocial)
    }

}