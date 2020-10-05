package com.app.socialapp.mvp.ui.moviespagesfragment

import com.app.socialapp.application.MainApplication

class MoviesPagesPresenter(val view: MoviesPagesContract.View) : MoviesPagesContract.Presenter {

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