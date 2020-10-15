package com.app.socialapp.mvp.ui.fragment.dialog.bottom.addcategory

import com.app.socialapp.application.MainApplication
import com.app.socialapp.entities.ItemCategory
import com.app.socialapp.room.CategoryDao
import javax.inject.Inject

class AddCategoryPresenter(val view: AddCategoryContract.View) : AddCategoryContract.Presenter {

    @Inject
    lateinit var categoryDao: CategoryDao

    init {
        MainApplication.applicationComponent.inject(this)
    }

    override fun setCategory(title: String) {
        val itemCategory = ItemCategory(title)
        categoryDao.insert(itemCategory)
    }

    override fun onAddInCategory() {
        view.addInCategory()
    }

}