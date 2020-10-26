package com.app.socialapp.mvp.ui.fragment.search

import io.reactivex.rxjava3.disposables.Disposable

interface SearchContract {

    interface View {
        fun clickSearch()
        fun showMovie(moviePoster: String?, movieTitle: String?, movieDescription: String?)
        fun getDisposableList(): MutableList<Disposable>
    }

    interface Presenter {
        fun onClickSearch()
        fun searchMovie(name: String)
    }

}