package com.app.socialapp.mvp.ui.host.fragment.movies

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import com.app.socialapp.R
import com.app.socialapp.fragment.BaseFragment
import com.app.socialapp.mvp.fragmentadapter.AdapterHost
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_movies_host.*

class HostMoviesFragment : BaseFragment(), HostMoviesContract.View {

    var presenter: HostMoviesContract.Presenter? = null
    var adapter: AdapterHost? = null
    var disList: MutableList<Disposable> = mutableListOf()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("LifecycleFragmentInit: ", "onCreate")
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_host, container, false)


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
            presenter = HostMoviesPresenter(this)
        presenter?.onShowMoviesFragment()
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
            adapter = AdapterHost(childFragmentManager, 1)
        }
        vpSocial.adapter = adapter
        tabDiffSocial.setupWithViewPager(vpSocial)
    }

}