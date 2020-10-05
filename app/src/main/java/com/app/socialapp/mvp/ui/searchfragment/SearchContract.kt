package com.app.socialapp.mvp.ui.searchfragment

interface SearchContract {
    interface View {
        fun clickSearch()
        fun showMovie(moviePoster: String?, movieTitle: String?, movieDescription: String?)
        fun clickBack()
        fun backToTheMoviesFragment()

    }

    interface Presenter {
        fun onClickSearch()
        fun searchMovie(name: String)
        fun onClickBack()
        fun onBackToTheMoviesFragment()


    }
}