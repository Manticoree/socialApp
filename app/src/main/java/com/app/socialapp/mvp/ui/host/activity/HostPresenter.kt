package com.app.socialapp.mvp.ui.host.activity

class HostPresenter(val view: HostContract.View) : HostContract.Presenter {

    override fun onGoToTheSearchView() {
        view.goToTheSearchView()
    }

    override fun onShowSearchFragment() {
        view.showSearchFragment()
    }

}