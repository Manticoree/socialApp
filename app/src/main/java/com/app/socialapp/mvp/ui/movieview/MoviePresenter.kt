package com.app.socialapp.mvp.ui.movieview

import com.app.socialapp.application.MainApplication

class MoviePresenter(view: MovieContract.View) : MovieContract.Presenter {
    init {
        MainApplication.applicationComponent.inject(this)
    }

    override fun onShowRecyclerView() {
        TODO("Not yet implemented")
    }
}