package com.app.socialapp.mvp.ui.fragment.mycategories

interface MyCategoriesContract {
    interface View {
        fun visibilityCategory(text: Int, button: Int, recView: Int)
        fun showCategoryList()
        fun showAddCategory()
        fun addCategory()
        fun clickAddCategory()
    }

    interface Presenter {
        fun getCategories()
    }
}