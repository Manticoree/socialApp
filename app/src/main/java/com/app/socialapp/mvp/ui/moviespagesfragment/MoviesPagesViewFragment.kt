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
import io.reactivex.rxjava3.disposables.Disposable

import kotlinx.android.synthetic.main.fragment_movies.*

class MoviesPagesViewFragment : BaseFragment(), MoviesPagesContract.View {

    var presenter: MoviesPagesContract.Presenter? = null
    var adapter: AdapterSocial? = null
    var disList: MutableList<Disposable> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainApplication.applicationComponent.inject(this)
        Log.i("LifecycleFragmentInit: ", "onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_movies, container, false)
        retainInstance = true
        Log.i("LifecycleFragmentInit: ", "onCreateView")
        return view
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
        if (presenter == null)
            presenter = MoviesPagesPresenter(this)
        presenter?.onShowMoviesFragment()
        presenter?.onGoToTheSearchView()
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
        adapter = null
        presenter = null
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
        if (adapter == null) {
            Log.i("LifecycleFragmentInit: ", "showMoviesInside")
            adapter = AdapterSocial(childFragmentManager, 1)
        }
        vpSocial.adapter = adapter
        tabDiffSocial.setupWithViewPager(vpSocial)
    }

    override fun goToTheSearchView() {
        disList.add(fabAddMovies.clicks().subscribe {
            presenter?.onShowSearchFragment()
        })
    }

    override fun showSearchFragment() {
        var fTransaction: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
        fTransaction.replace(
                R.id.fcvFragment,
                SearchViewFragment()
        )
                .addToBackStack(null)
                .commit()
    }
}