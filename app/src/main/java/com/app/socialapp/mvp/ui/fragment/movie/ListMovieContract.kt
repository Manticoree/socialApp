package com.app.socialapp.mvp.ui.fragment.movie

import com.app.socialapp.adapter.flexadapter.MoviesImdbAdapter

interface ListMovieContract {

    interface View {
        fun showRecyclerView(initList: List<MoviesImdbAdapter>)
        fun goToTheSearchView()
        fun showSearchFragment()
    }

    interface Presenter {
        fun onShowRecyclerView()
        fun initDataFromDB()
        fun onGoToTheSearchView()
        fun onShowSearchFragment()
        fun cleanMemory()
    }
}