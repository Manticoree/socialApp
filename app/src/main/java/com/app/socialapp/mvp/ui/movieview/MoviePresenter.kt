package com.app.socialapp.mvp.ui.movieview


import android.util.Log
import com.app.socialapp.adapter.SocialNetworkAdapter
import com.app.socialapp.application.MainApplication
import com.app.socialapp.room.MoviesDao
import javax.inject.Inject

class MoviePresenter(var view: MovieContract.View) : MovieContract.Presenter {

    var moviesDao: MoviesDao? = null
        @Inject set

    var initList: ArrayList<SocialNetworkAdapter> = ArrayList()

    init {
        MainApplication.applicationComponent.inject(this)
    }

    override fun onShowRecyclerView() {
        initDataFromDB()
    }

    override fun initDataFromDB() {
        Log.i("movies in database: ", moviesDao?.getAll().toString())
        if (moviesDao?.getAll() != null) {
            for (i in moviesDao?.getAll()!!) {

                initList.add(SocialNetworkAdapter(i))
            }
            view.showRecyclerView(initList)
        }
/*
        moviesDao?.getAll()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(object : SingleObserver<List<ItemNews>> {
                    override fun onSuccess(item: List<ItemNews>?) {
                        if (item != null) {
                            for (e in item) {
                                initList = listOf(SocialNetworkAdapter(e))
                            }
                            view.showRecyclerView(initList)
                        }
                    }

                    override fun onSubscribe(d: Disposable?) {
                        TODO("Not yet implemented")
                    }

                    override fun onError(e: Throwable?) {
                        TODO("Not yet implemented")
                    }

                })

*/
    }

}