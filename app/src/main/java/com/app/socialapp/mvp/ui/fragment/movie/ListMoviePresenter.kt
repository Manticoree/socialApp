package com.app.socialapp.mvp.ui.fragment.movie


import com.app.socialapp.adapter.flexadapter.MoviesImdbAdapter
import com.app.socialapp.domain.entities.db.ItemMovieDb
import com.app.socialapp.domain.repository.db.ShowListMoviesRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class ListMoviePresenter(var view: ListMovieContract.View) : ListMovieContract.Presenter {

    val showListMoviesRepository: ShowListMoviesRepository = ShowListMoviesRepository()
    var initList: MutableList<MoviesImdbAdapter> = mutableListOf()

    override fun onShowRecyclerView() {
        initDataFromDB()
    }

    override fun initDataFromDB() {
        showListMoviesRepository
                .getDataFromDB()
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

    override fun onGoToTheSearchView() {
        view.goToTheSearchView()
    }

    override fun onShowSearchFragment() {
        view.showSearchFragment()
    }

    override fun cleanMemory() {
        initList.clear()
    }

}