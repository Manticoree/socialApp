package com.app.socialapp.data.repository.remote.imdb

import com.app.socialapp.application.MainApplication
import com.app.socialapp.data.entities.imdb.ItemMovieImdb
import com.app.socialapp.data.local.room.MoviesDao
import com.app.socialapp.data.remote.retrofit.ServiceImdb
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class SearchMoviesRepository {

    @Inject
    lateinit var serviceImdb: ServiceImdb

    @Inject
    lateinit var moviesDao: MoviesDao

    init {
        MainApplication.applicationComponent.inject(this)
    }

    companion object {
        const val IMBD_TOKEN: String = "9531f308"
    }

    fun getMovie(name: String): Single<ItemMovieImdb> {
        return serviceImdb.getMovies(name, IMBD_TOKEN)
    }

}