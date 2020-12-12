package com.app.socialapp.domain.repository.remote.tmdb

import android.util.Log
import com.app.socialapp.application.MainApplication
import com.app.socialapp.domain.entities.db.ItemTopMoviesDb
import com.app.socialapp.domain.entities.tmdb.ItemMovie
import com.app.socialapp.domain.entities.tmdb.ItemTopMovies
import com.app.socialapp.domain.local.room.TopMoviesDao
import com.app.socialapp.domain.mapper.item.ItemTopMapperImpl
import com.app.socialapp.domain.remote.retrofit.ServiceTmdb
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.functions.BiFunction
import io.reactivex.rxjava3.functions.Function7
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
        const val PAGE = 1
        const val PRIMARY_RELEASE_2020 = "2020"
        const val PRIMARY_RELEASE_2019 = "2019"
        const val PRIMARY_RELEASE_2018 = "2018"
        const val PRIMARY_RELEASE_2017 = "2017"
        const val PRIMARY_RELEASE_2016 = "2016"
        const val PRIMARY_RELEASE_2015 = "2015"
        const val PRIMARY_RELEASE_2014 = "2014"
        const val PRIMARY_RELEASE_2013 = "2013"
        const val PRIMARY_RELEASE_2012 = "2012"
        const val PRIMARY_RELEASE_2011 = "2011"
        const val PRIMARY_RELEASE_2010 = "2010"
        const val PRIMARY_RELEASE_2009 = "2009"
        const val PRIMARY_RELEASE_2008 = "2008"
        const val PRIMARY_RELEASE_2007 = "2007"
        const val PRIMARY_RELEASE_2006 = "2006"
        const val API_KEY = "93ab2fe14a1dc7357659e0c56f2b93c4"
    }

    fun getDbMovies(year: Int): List<ItemTopMoviesDb> {
        Log.i("getFrom: ", dao.getByYear(year).toString())
        return dao.getByYear(year)
    }

    fun getMovies(): Single<List<ItemTopMovies>> {
        val movies2020Item: Single<ItemTopMovies> = serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2020,
                API_KEY,
                PAGE
        )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

        val movies2019Item: Single<ItemTopMovies> = serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2019,
                API_KEY,
                PAGE
        )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        val movies2018Item: Single<ItemTopMovies> = serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2018,
                API_KEY,
                PAGE
        )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        val movies2017Item: Single<ItemTopMovies> = serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2017,
                API_KEY,
                PAGE
        )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        val movies2016Item: Single<ItemTopMovies> = serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2016,
                API_KEY,
                PAGE
        )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        val movies2015Item: Single<ItemTopMovies> = serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2015,
                API_KEY,
                PAGE
        )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        val movies2014Item: Single<ItemTopMovies> = serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2014,
                API_KEY,
                PAGE
        )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        val movies2013Item: Single<ItemTopMovies> = serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2013,
                API_KEY,
                PAGE
        )
        val movies2012Item: Single<ItemTopMovies> = serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2012,
                API_KEY,
                PAGE
        )
        val movies2011Item: Single<ItemTopMovies> = serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2011,
                API_KEY,
                PAGE
        )
        val movies2010Item: Single<ItemTopMovies> = serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2010,
                API_KEY,
                PAGE
        )
        val movies2009Item: Single<ItemTopMovies> = serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2009,
                API_KEY,
                PAGE
        )
        val movies2008Item: Single<ItemTopMovies> = serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2008,
                API_KEY,
                PAGE
        )
        val movies2007Item: Single<ItemTopMovies> = serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2007,
                API_KEY,
                PAGE
        )
        val movies2006Item: Single<ItemTopMovies> = serviceTmdb.getTopMoviesInYears(
                PRIMARY_RELEASE_2006,
                API_KEY,
                PAGE
        )

                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        val lowMovies: Single<List<ItemTopMovies>> = Single.zip(
                movies2012Item,
                movies2011Item,
                movies2010Item,
                movies2009Item,
                movies2008Item,
                movies2007Item,
                movies2006Item,
                Function7<
                        ItemTopMovies,
                        ItemTopMovies,
                        ItemTopMovies,
                        ItemTopMovies,
                        ItemTopMovies,
                        ItemTopMovies,
                        ItemTopMovies,
                        List<ItemTopMovies>
                        > { topMovies2012,
                            topMovies2011,
                            topMovies2010,
                            topMovies2009,
                            topMovies2008,
                            topMovies2007,
                            topMovies2006, ->
                    val listTopMovies = mutableListOf(
                            topMovies2006,
                            topMovies2007,
                            topMovies2008,
                            topMovies2009,
                            topMovies2010,
                            topMovies2011,
                            topMovies2012
                    )
                    listTopMovies
                }
        )

        val highMovies: Single<List<ItemTopMovies>> = Single.zip(
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
                    listTopMovies.forEach {
                        Log.i("listTopMovies: ", it.results.toString())
                    }
                    listTopMovies
                }
        )
        return Single.zip(lowMovies, highMovies, BiFunction<List<ItemTopMovies>, List<ItemTopMovies>, MutableList<ItemTopMovies>>
        { low,
          high ->
            val lowhigh: MutableList<ItemTopMovies> = mutableListOf()
            lowhigh.apply {
                plusAssign(low)
                plusAssign(high)
            }
            lowhigh
        })
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