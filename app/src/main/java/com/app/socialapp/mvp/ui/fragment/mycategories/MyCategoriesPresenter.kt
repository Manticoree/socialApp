package com.app.socialapp.mvp.ui.fragment.mycategories

import com.app.socialapp.application.MainApplication

class MyCategoriesPresenter(val view: MyCategoriesContract.View) : MyCategoriesContract.Presenter {
    init {
        MainApplication.applicationComponent.inject(this)
    }
}