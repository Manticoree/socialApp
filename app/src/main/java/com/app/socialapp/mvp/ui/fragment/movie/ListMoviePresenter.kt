package com.app.socialapp.mvp.ui.fragment.movie


import android.util.Log
import com.app.socialapp.adapter.MoviesImdbAdapter
import com.app.socialapp.application.MainApplication
import com.app.socialapp.data.local.room.MoviesDao
import javax.inject.Inject

class ListMoviePresenter(var view: ListMovieContract.View) : ListMovieContract.Presenter {

    var moviesDao: MoviesDao? = null
        @Inject set

    var initList: MutableList<MoviesImdbAdapter> = mutableListOf()

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

                initList.add(MoviesImdbAdapter(i))
            }
            Log.i("movies in list: ", initList.toString())
            initList?.let { view.showRecyclerView(it) }
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

    override fun cleanMemory() {
        initList.clear()
    }

}