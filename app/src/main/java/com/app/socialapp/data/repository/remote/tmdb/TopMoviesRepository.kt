package com.app.socialapp.data.repository.remote.tmdb

import android.util.Log
import com.app.socialapp.application.MainApplication
import com.app.socialapp.data.entities.db.ItemTopMoviesDb
import com.app.socialapp.data.entities.tmdb.ItemMovie
import com.app.socialapp.data.entities.tmdb.ItemTopMovies
import com.app.socialapp.data.local.room.TopMoviesDao
import com.app.socialapp.data.mapper.item.ItemTopMapperImpl
import com.app.socialapp.data.remote.retrofit.ServiceTmdb
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.functions.Function8
import io.reactivex.rxjava3.observers.DisposableCompletableObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class TopMoviesRepository {

    @Inject
    lateinit var serviceTmdb: ServiceTmdb

    @Inject
    lateinit var dao: TopMoviesDao

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
        const val PRIMARY_RELEASE_2012 = "2013"
        const val PRIMARY_RELEASE_2011 = "2011"
        const val PRIMARY_RELEASE_2010 = "2010"
        const val PRIMARY_RELEASE_2009 = "2009"
        const val PRIMARY_RELEASE_2008 = "2008"
        const val PRIMARY_RELEASE_2007 = "2007"
        const val PRIMARY_RELEASE_2006 = "2006"
        const val SORT_BY = "vote_average.desc"
        const val API_KEY = "93ab2fe14a1dc7357659e0c56f2b93c4"
    }

    fun getDbMovies(year: Int): List<ItemTopMoviesDb> {
        Log.i("getFrom: ", dao.getByYear(year).toString())
        return dao.getByYear(year)
    }

    fun getMovies(): Single<List<ItemTopMovies>> {
        val movies2020Item: Single<ItemTopMovies> = serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2020,
                SORT_BY,
                API_KEY
        )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

        val movies2019Item: Single<ItemTopMovies> = serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2019,
                SORT_BY,
                API_KEY
        )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        val movies2018Item: Single<ItemTopMovies> = serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2018,
                SORT_BY,
                API_KEY
        )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        val movies2017Item: Single<ItemTopMovies> = serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2017,
                SORT_BY,
                API_KEY
        )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        val movies2016Item: Single<ItemTopMovies> = serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2016,
                SORT_BY,
                API_KEY
        )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        val movies2015Item: Single<ItemTopMovies> = serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2015,
                SORT_BY,
                API_KEY
        )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        val movies2014Item: Single<ItemTopMovies> = serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2014,
                SORT_BY,
                API_KEY
        )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        val movies2013Item: Single<ItemTopMovies> = serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2013,
                SORT_BY,
                API_KEY
        )
        val movies2012Item: Single<ItemTopMovies> = serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2012,
                SORT_BY,
                API_KEY
        )
        val movies2011Item: Single<ItemTopMovies> = serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2011,
                SORT_BY,
                API_KEY
        )
        val movies2010Item: Single<ItemTopMovies> = serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2010,
                SORT_BY,
                API_KEY
        )
        val movies2009Item: Single<ItemTopMovies> = serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2009,
                SORT_BY,
                API_KEY
        )
        val movies2008Item: Single<ItemTopMovies> = serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2008,
                SORT_BY,
                API_KEY
        )
        val movies2007Item: Single<ItemTopMovies> = serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2007,
                SORT_BY,
                API_KEY
        )
        val movies2006Item: Single<ItemTopMovies> = serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2006,
                SORT_BY,
                API_KEY
        )

                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        return Single.zip(
                movies2020Item,
                movies2019Item,
                movies2018Item,
                movies2017Item,
                movies2016Item,
                movies2015Item,
                movies2014Item,
                movies2013Item,
                Function8<
                        ItemTopMovies,
                        ItemTopMovies,
                        ItemTopMovies,
                        ItemTopMovies,
                        ItemTopMovies,
                        ItemTopMovies,
                        ItemTopMovies,
                        ItemTopMovies,
                        List<ItemTopMovies>
                        > { topMovies2020,
                            topMovies2019,
                            topMovies2018,
                            topMovies2017,
                            topMovies2016,
                            topMovies2015,
                            topMovies2014,
                            topMovies2013 ->

                    // putRequestInDb(topMovies2020.results, 2020)
                    // putRequestInDb(topMovies2019.results, 2019)
                    //putRequestInDb(topMovies2018.results, 2018)
                    //putRequestInDb(topMovies2017.results, 2017)
                    // putRequestInDb(topMovies2016.results, 2016)
                    // putRequestInDb(topMovies2015.results, 2015)
                    //  putRequestInDb(topMovies2014.results, 2014)
                    //  putRequestInDb(topMovies2013.results, 2013)

                    val listTopMovies = mutableListOf(
                            topMovies2013,
                            topMovies2014,
                            topMovies2015,
                            topMovies2016,
                            topMovies2017,
                            topMovies2018,
                            topMovies2019,
                            topMovies2020
                    )
                    listTopMovies
                }
        )
    }

    fun putRequestInDb(list: List<ItemMovie>, year: Int) {
        list.forEach {
            Log.i("putDataInDb: ", "$year $it")
        }

        list.forEach {
            dao.insert(ItemTopMapperImpl.convert(it, year))
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(object : DisposableCompletableObserver() {

                        override fun onComplete() {
                            Log.i("onComplete: ", "")
                        }

                        override fun onError(e: Throwable?) {
                            e?.localizedMessage?.let { it1 -> Log.e("onError: ", it1) }
                        }

                    })
        }

    }

}