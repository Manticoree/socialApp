package com.app.socialapp.mvp.ui.socialactivity

interface SocialContract {

    interface View {
        fun showMoviesFragment()
    }

    interface Presenter {
        fun onShowMoviesFragment()
    }

}