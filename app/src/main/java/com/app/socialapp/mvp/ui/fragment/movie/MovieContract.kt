package com.app.socialapp.mvp.ui.fragment.movie

import com.app.socialapp.adapter.SocialNetworkAdapter

interface MovieContract {

    interface View {
        fun showRecyclerView(initList: List<SocialNetworkAdapter>)
    }

    interface Presenter {
        fun onShowRecyclerView()
        fun initDataFromDB()
        fun cleanMemory()
    }
}