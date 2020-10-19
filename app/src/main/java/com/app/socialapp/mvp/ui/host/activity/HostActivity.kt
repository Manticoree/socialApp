package com.app.socialapp.mvp.ui.host.activity

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.app.socialapp.R
import com.app.socialapp.application.BaseActivity
import com.jakewharton.rxbinding4.view.clicks
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.android.synthetic.main.activity_host.*

class HostActivity : BaseActivity(), HostContract.View {

    lateinit var presenter: HostContract.Presenter
    private lateinit var navController: NavController
    var disList: MutableList<Disposable> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host)
        presenter = HostPresenter(this)
        navController = Navigation.findNavController(this, R.id.fcvFragment)
        NavigationUI.setupWithNavController(btmNavigation, navController)
        presenter.onGoToTheSearchView()
    }

    override fun goToTheSearchView() {
        disList.add(fabAddMovies.clicks().subscribe {
            presenter.onShowSearchFragment()
        })
    }

    override fun showSearchFragment() {
        navController.navigate(R.id.action_host_to_search)
    }

}