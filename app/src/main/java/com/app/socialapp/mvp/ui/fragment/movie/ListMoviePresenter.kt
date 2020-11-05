package com.app.socialapp.mvp.ui.fragment.movie


import com.app.socialapp.adapter.flexadapter.MoviesImdbAdapter
import com.app.socialapp.application.MainApplication
import com.app.socialapp.data.entities.db.ItemMovieDb
import com.app.socialapp.data.local.room.MoviesDao
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ListMoviePresenter(var view: ListMovieContract.View) : ListMovieContract.Presenter {

    @Inject
    lateinit var moviesDao: MoviesDao

    var initList: MutableList<MoviesImdbAdapter> = mutableListOf()

    init {
        MainApplication.applicationComponent.inject(this)
    }

    override fun onShowRecyclerView() {
        initDataFromDB()
    }

    override fun initDataFromDB() {
        moviesDao.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<List<ItemMovieDb>> {

                    override fun onSuccess(t: List<ItemMovieDb>?) {
                        t?.forEach { initList.add(MoviesImdbAdapter(it)) }
                        view.showRecyclerView(initList)
                    }

                    override fun onSubscribe(d: Disposable?) {

                    }

                    override fun onError(e: Throwable?) {

                    }

                })


    }

    override fun cleanMemory() {
        initList.clear()
    }

}