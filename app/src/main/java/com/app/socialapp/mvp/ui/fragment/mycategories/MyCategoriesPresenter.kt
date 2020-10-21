package com.app.socialapp.mvp.ui.fragment.mycategories

import com.app.socialapp.adapter.CategoryAdapter
import com.app.socialapp.application.MainApplication
import com.app.socialapp.data.local.room.CategoryDao
import javax.inject.Inject

class MyCategoriesPresenter(val view: MyCategoriesContract.View) : MyCategoriesContract.Presenter {

    @Inject
    lateinit var categoryDao: CategoryDao

    var categoryList: MutableList<CategoryAdapter> = mutableListOf()

    init {
        MainApplication.applicationComponent.inject(this)
    }


    override fun getCategories() {
        if (categoryDao.getAll().isEmpty()) {
            view.showAddCategory()
        } else {
            view.showCategoryList()
            for (item in categoryDao.getAll())
                categoryList.add(CategoryAdapter(item))
        }
        view.showRecyclerView(categoryList)
    }

    override fun onAddCategory() {
        view.addCategory()
    }

    override fun onClickAddCategory() {
        view.clickAddCategory()
    }


}