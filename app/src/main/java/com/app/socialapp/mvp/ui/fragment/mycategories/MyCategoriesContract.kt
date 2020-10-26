package com.app.socialapp.mvp.ui.fragment.mycategories

import com.app.socialapp.adapter.CategoryAdapter

interface MyCategoriesContract {

    interface View {
        fun visibilityCategory(text: Int, button: Int, recView: Int)
        fun showCategoryList()
        fun showAddCategory()
        fun addCategory()
        fun clickAddCategory()
        fun showRecyclerView(initList: List<CategoryAdapter>)
    }

    interface Presenter {
        fun getCategories()
        fun onAddCategory()
        fun onClickAddCategory()
    }

}