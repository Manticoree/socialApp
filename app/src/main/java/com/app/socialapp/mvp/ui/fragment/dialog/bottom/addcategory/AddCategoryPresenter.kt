package com.app.socialapp.mvp.ui.fragment.dialog.bottom.addcategory

import com.app.socialapp.base.MainApplication
import com.app.socialapp.domain.entities.db.ItemCategory
import com.app.socialapp.domain.local.room.CategoryDao
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
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
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
    }

    override fun onAddInCategory() {
        view.addInCategory()
    }

}