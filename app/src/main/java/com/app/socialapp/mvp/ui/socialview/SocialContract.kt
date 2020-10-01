package com.app.socialapp.mvp.ui.socialview

interface SocialContract {

    interface View {
        fun showMoviesFragment()
    }

    interface Presenter {
        fun onShowMoviesFragment()
    }

}