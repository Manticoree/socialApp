package com.app.socialapp.mvp.ui.searchview

interface SearchContract {
    interface View {
        fun onClickSearch()
        fun showMovieFragment()
    }

    interface Presenter {
        fun searchMovie(name: String)
        fun onShowMovieFragment()

    }
}