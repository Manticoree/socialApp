package com.app.socialapp.mvp.ui.movieview

import com.app.socialapp.adapter.SocialNetworkAdapter

interface MovieContract {

    interface View {
        fun showRecyclerView(initList: List<SocialNetworkAdapter>)
    }

    interface Presenter {
        fun onShowRecyclerView();
    }
}