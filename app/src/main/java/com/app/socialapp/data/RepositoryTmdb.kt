package com.app.socialapp.data

import com.app.socialapp.adapter.TopMoviesTmdbAdapter
import com.app.socialapp.application.MainApplication
import com.app.socialapp.data.entities.tmdb.TopMovies
import com.app.socialapp.data.remote.retrofit.ServiceTmdb
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class RepositoryTmdb {

    @Inject
    lateinit var serviceTmdb: ServiceTmdb

    var data: MutableList<TopMoviesTmdbAdapter> = mutableListOf()

    init {
        MainApplication.applicationComponent.inject(this)
    }

    fun getMovies(): List<TopMoviesTmdbAdapter> {
        refreshData("2000",
                "vote_average.desc",
                "93ab2fe14a1dc7357659e0c56f2b93c4")
        return data
    }

    private fun refreshData(primaryRelease: String, sortBy: String, apiKey: String) {
        serviceTmdb.getTopMoviesInYears(
                primaryRelease,
                sortBy,
                apiKey
        ).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(object : SingleObserver<TopMovies> {
                    override fun onSuccess(t: TopMovies) {
                        for (item in t.results) {
                            data.add(TopMoviesTmdbAdapter(item))
                        }
                    }

                    override fun onSubscribe(d: Disposable?) {

                    }

                    override fun onError(e: Throwable?) {

                    }

                })
    }

}