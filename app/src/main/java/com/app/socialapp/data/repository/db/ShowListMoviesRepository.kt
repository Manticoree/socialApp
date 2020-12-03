package com.app.socialapp.data.repository.db

import com.app.socialapp.application.MainApplication
import com.app.socialapp.data.entities.db.ItemMovieDb
import com.app.socialapp.data.local.room.MoviesDao
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ShowListMoviesRepository {

    @Inject
    lateinit var moviesDao: MoviesDao

    init {
        MainApplication.applicationComponent.inject(this)
    }

    fun getDataFromDB(): Single<List<ItemMovieDb>> {
        return moviesDao.getAll()
    }

}