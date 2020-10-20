package com.app.socialapp.mvp.ui.fragment.movie

import com.app.socialapp.adapter.MoviesImdbAdapter

interface ListMovieContract {

    interface View {
        fun showRecyclerView(initList: List<MoviesImdbAdapter>)
    }

    interface Presenter {
        fun onShowRecyclerView()
        fun initDataFromDB()
        fun cleanMemory()
    }
}