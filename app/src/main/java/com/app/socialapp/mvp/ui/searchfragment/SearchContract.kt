package com.app.socialapp.mvp.ui.searchfragment

import io.reactivex.rxjava3.disposables.Disposable

interface SearchContract {
    interface View {
        fun clickSearch()
        fun showMovie(moviePoster: String?, movieTitle: String?, movieDescription: String?)
        fun clickBack()
        fun backToTheMoviesFragment()
        fun getDisposableList(): MutableList<Disposable>
    }

    interface Presenter {
        fun onClickSearch()
        fun searchMovie(name: String)
        fun onClickBack()
        fun onBackToTheMoviesFragment()

    }
}