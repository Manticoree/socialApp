package com.app.socialapp.mvp.ui.fragment.movie

import com.app.socialapp.adapter.MoviesAdapter

interface MovieContract {

    interface View {
        fun showRecyclerView(initList: List<MoviesAdapter>)
    }

    interface Presenter {
        fun onShowRecyclerView()
        fun initDataFromDB()
        fun cleanMemory()
    }
}