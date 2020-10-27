package com.app.socialapp.mvp.ui.fragment.movie


import android.util.Log
import com.app.socialapp.adapter.MoviesImdbAdapter
import com.app.socialapp.application.MainApplication
import com.app.socialapp.data.local.room.MoviesDao
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
        Log.i("movies in database: ", moviesDao.getAll().toString())
        for (i in moviesDao.getAll()) {
            initList.add(MoviesImdbAdapter(i))
        }
        Log.i("movies in list: ", initList.toString())
        initList.let { view.showRecyclerView(it) }

    }

    override fun cleanMemory() {
        initList.clear()
    }

}