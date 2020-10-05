package com.app.socialapp.mvp.ui.moviespagesfragment

interface MoviesPagesContract {

    interface View {

        fun showMoviesFragment()

        fun goToTheSearchView()

        fun showSearchFragment()
    }

    interface Presenter {

        fun onShowMoviesFragment()

        fun onGoToTheSearchView()

        fun onShowSearchFragment()
    }

}