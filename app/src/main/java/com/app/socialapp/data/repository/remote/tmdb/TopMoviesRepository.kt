package com.app.socialapp.data.repository.remote.tmdb

import com.app.socialapp.adapter.TopMoviesTmdbAdapter
import com.app.socialapp.application.MainApplication
import com.app.socialapp.data.entities.tmdb.TopMovies
import com.app.socialapp.data.remote.retrofit.ServiceTmdb
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class TopMoviesRepository {

    @Inject
    lateinit var serviceTmdb: ServiceTmdb

    var data: MutableList<TopMoviesTmdbAdapter> = mutableListOf()

    init {
        MainApplication.applicationComponent.inject(this)
    }

    companion object {
        const val PRIMARY_RELEASE = "2000"
        const val SORT_BY = "vote_average.desc"
        const val API_KEY = "93ab2fe14a1dc7357659e0c56f2b93c4"
    }

    fun getMovies(): Single<TopMovies> {
        return serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE,
                SORT_BY,
                API_KEY)
    }

}