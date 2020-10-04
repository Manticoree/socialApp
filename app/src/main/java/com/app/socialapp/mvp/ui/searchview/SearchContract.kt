package com.app.socialapp.mvp.ui.searchview

interface SearchContract {
    interface View {
        fun onClickSearch()
        fun showMovie(moviePoster: String?, movieTitle: String?, movieDescription: String?)

    }

    interface Presenter {
        fun searchMovie(name: String)


    }
}