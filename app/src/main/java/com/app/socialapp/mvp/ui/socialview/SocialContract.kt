package com.app.socialapp.mvp.ui.socialview

interface SocialContract {

    interface View {
        fun showMoviesFragment()
        fun goToTheSearchView()
        fun showSearchFragment()
    }

    interface Presenter {
        fun onShowMoviesFragment()
        fun onShowSearchFragment()
        fun onGoToTeSearchView()
    }

}