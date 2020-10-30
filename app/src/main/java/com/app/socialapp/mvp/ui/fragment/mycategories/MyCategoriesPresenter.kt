package com.app.socialapp.mvp.ui.fragment.mycategories

import com.app.socialapp.adapter.CategoryAdapter
import com.app.socialapp.application.MainApplication
import com.app.socialapp.data.entities.db.ItemCategory
import com.app.socialapp.data.local.room.CategoryDao
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MyCategoriesPresenter(val view: MyCategoriesContract.View) : MyCategoriesContract.Presenter {

    @Inject
    lateinit var categoryDao: CategoryDao

    var categoryList: MutableList<CategoryAdapter> = mutableListOf()

    init {
        MainApplication.applicationComponent.inject(this)
    }

    override fun getCategories() {
        categoryDao.getAll().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<List<ItemCategory>> {
                    override fun onSuccess(t: List<ItemCategory>) {
                        if (t.isEmpty()) {
                            view.showAddCategory()
                        } else {
                            view.showCategoryList()
                            t.forEach { categoryList.add(CategoryAdapter(it)) }
                            view.showRecyclerView(categoryList)
                        }
                    }

                    override fun onSubscribe(d: Disposable?) {

                    }

                    override fun onError(e: Throwable?) {

                    }

                })

    }

    override fun onAddCategory() {
        view.addCategory()
    }

    override fun onClickAddCategory() {
        view.clickAddCategory()
    }

}