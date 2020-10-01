package com.app.socialapp.mvp.ui.socialview

import com.app.socialapp.application.MainApplication

class SocialPresenter(private val viewActivity: SocialViewActivity) : SocialContract.Presenter {

    init {
        MainApplication.applicationComponent?.inject(this)
    }

    override fun onShowMoviesFragment() {
        viewActivity.showMoviesFragment()
    }

}