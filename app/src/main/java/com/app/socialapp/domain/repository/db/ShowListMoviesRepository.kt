package com.app.socialapp.domain.repository.db

import com.app.socialapp.base.MainApplication
import com.app.socialapp.domain.entities.db.ItemMovieDb
import com.app.socialapp.domain.local.room.MoviesDao
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