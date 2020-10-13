package com.app.socialapp.mvp.ui.host.fragment

interface HostContract {

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