package com.app.socialapp.mvp.ui.host.fragment

import com.app.socialapp.application.MainApplication

class HostPresenter(val view: HostContract.View) : HostContract.Presenter {

    init {
        MainApplication.applicationComponent?.inject(this)
    }

    override fun onShowMoviesFragment() {
        view.showMoviesFragment()
    }

    override fun onGoToTheSearchView() {
        view.goToTheSearchView()
    }

    override fun onShowSearchFragment() {
        view.showSearchFragment()
    }


}