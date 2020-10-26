package com.app.socialapp.mvp.ui.host.fragment.movies


class HostMoviesPresenter(val view: HostMoviesContract.View) : HostMoviesContract.Presenter {

    override fun onShowMoviesFragment() {
        view.showMoviesFragment()
    }

}