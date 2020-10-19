package com.app.socialapp.mvp.ui.host.activity

interface HostContract {
    interface View {
        fun goToTheSearchView()

        fun showSearchFragment()
    }

    interface Presenter {
        fun onGoToTheSearchView()

        fun onShowSearchFragment()
    }
}