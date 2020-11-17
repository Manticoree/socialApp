package com.app.socialapp.data.repository.remote.tmdb

import com.app.socialapp.application.MainApplication
import com.app.socialapp.data.entities.tmdb.ItemTopMovies
import com.app.socialapp.data.remote.retrofit.ServiceTmdb
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class PopularMoviesRepository {

    @Inject
    lateinit var serviceTmdb: ServiceTmdb

    init {
        MainApplication.applicationComponent.inject(this)
    }

    companion object {
        const val SORT_BY = "vote_average.desc"
        const val API_KEY = "93ab2fe14a1dc7357659e0c56f2b93c4"
    }

    fun getPopularMovies(): Single<ItemTopMovies> {
        return serviceTmdb.getPopularMovies(SORT_BY, API_KEY)
    }

}