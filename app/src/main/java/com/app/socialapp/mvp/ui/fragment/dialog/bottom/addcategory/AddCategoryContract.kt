package com.app.socialapp.mvp.ui.fragment.dialog.bottom.addcategory

interface AddCategoryContract {

    interface View {
        fun addInCategory()
    }

    interface Presenter {
        fun setCategory(title: String)
        fun onAddInCategory()
    }

}