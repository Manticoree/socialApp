package com.app.socialapp.mvp.ui.host.fragment.movies

interface HostMoviesContract {

    interface View {

        fun showMoviesFragment()

    }

    interface Presenter {

        fun onShowMoviesFragment()

    }

}