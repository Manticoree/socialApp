package com.app.socialapp.mvp.ui.host.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.app.socialapp.R
import com.app.socialapp.application.MainApplication
import com.app.socialapp.fragment.BaseFragment
import com.app.socialapp.mvp.fragmentadapter.AdapterHost
import com.jakewharton.rxbinding4.view.clicks
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_host.*

class HostFragment : BaseFragment(), HostContract.View {

    var presenter: HostContract.Presenter? = null
    var adapter: AdapterHost? = null
    var disList: MutableList<Disposable> = mutableListOf()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainApplication.applicationComponent.inject(this)
        Log.i("LifecycleFragmentInit: ", "onCreate")
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_host, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        bottom_navigation.inflateMenu(R.menu.bottom_navigation_menu)
        Log.i("LifecycleFragmentInit: ", "onViewCreated")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("LifecycleFragmentInit: ", "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        if (presenter == null)
            presenter = HostPresenter(this)
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
            adapter = AdapterHost(childFragmentManager, 1)
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
        navController.navigate(R.id.action_host_to_search)
    }
}