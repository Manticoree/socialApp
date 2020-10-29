package com.app.socialapp.data.repository.remote.tmdb

import com.app.socialapp.application.MainApplication
import com.app.socialapp.data.entities.tmdb.TopMovies
import com.app.socialapp.data.remote.retrofit.ServiceTmdb
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.functions.Function8
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class TopMoviesRepository {

    @Inject
    lateinit var serviceTmdb: ServiceTmdb

    val movies2020: Single<TopMovies> = serviceTmdb.getTopMoviesInYears(
            PRIMARY_RELEASE_2020,
            SORT_BY,
            API_KEY
    )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    val movies2019: Single<TopMovies> = serviceTmdb.getTopMoviesInYears(
            PRIMARY_RELEASE_2019,
            SORT_BY,
            API_KEY
    )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    val movies2018: Single<TopMovies> = serviceTmdb.getTopMoviesInYears(
            PRIMARY_RELEASE_2018,
            SORT_BY,
            API_KEY
    )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    val movies2017: Single<TopMovies> = serviceTmdb.getTopMoviesInYears(
            PRIMARY_RELEASE_2017,
            SORT_BY,
            API_KEY
    )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    val movies2016: Single<TopMovies> = serviceTmdb.getTopMoviesInYears(
            PRIMARY_RELEASE_2016,
            SORT_BY,
            API_KEY
    )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    val movies2015: Single<TopMovies> = serviceTmdb.getTopMoviesInYears(
            PRIMARY_RELEASE_2015,
            SORT_BY,
            API_KEY
    )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    val movies2014: Single<TopMovies> = serviceTmdb.getTopMoviesInYears(
            PRIMARY_RELEASE_2014,
            SORT_BY,
            API_KEY
    )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    val movies2013: Single<TopMovies> = serviceTmdb.getTopMoviesInYears(
            PRIMARY_RELEASE_2013,
            SORT_BY,
            API_KEY
    )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    init {
        MainApplication.applicationComponent.inject(this)
    }

    companion object {
        const val PRIMARY_RELEASE_2020 = "2020"
        const val PRIMARY_RELEASE_2019 = "2019"
        const val PRIMARY_RELEASE_2018 = "2018"
        const val PRIMARY_RELEASE_2017 = "2017"
        const val PRIMARY_RELEASE_2016 = "2016"
        const val PRIMARY_RELEASE_2015 = "2015"
        const val PRIMARY_RELEASE_2014 = "2014"
        const val PRIMARY_RELEASE_2013 = "2013"
        const val SORT_BY = "vote_average.desc"
        const val API_KEY = "93ab2fe14a1dc7357659e0c56f2b93c4"
    }

    fun getMovies(): Single<TopMovies> {
        val moviesAllYear: Single<List<TopMovies>> = Single.zip(
                movies2020,
                movies2019,
                movies2018,
                movies2017,
                movies2016,
                movies2015,
                movies2014,
                movies2013,
                Function8<
                        TopMovies,
                        TopMovies,
                        TopMovies,
                        TopMovies,
                        TopMovies,
                        TopMovies,
                        TopMovies,
                        TopMovies,
                        List<TopMovies>
                        > { movies2020,
                            movies2019,
                            movies2018,
                            movies2017,
                            movies2016,
                            movies2015,
                            movies2014,
                            movies2013 ->

                }
        )
        return serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2020,
                SORT_BY,
                API_KEY)
    }

}