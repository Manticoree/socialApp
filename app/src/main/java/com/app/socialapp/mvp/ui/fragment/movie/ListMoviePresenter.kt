package com.app.socialapp.mvp.ui.fragment.movie


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
        moviesDao.getAll().forEach { initList.add(MoviesImdbAdapter(it)) }
        view.showRecyclerView(initList)
    }

    override fun cleanMemory() {
        initList.clear()
    }

}