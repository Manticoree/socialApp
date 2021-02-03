package com.app.socialapp.domain.repository.remote.imdb

import android.util.Log
import com.app.socialapp.base.MainApplication
import com.app.socialapp.domain.entities.imdb.ItemMovieImdb
import com.app.socialapp.domain.local.room.MoviesDao
import com.app.socialapp.domain.mapper.item.ItemMapperImpl
import com.app.socialapp.domain.remote.retrofit.ServiceImdb
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
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
                .doOnSuccess {
                    moviesDao.insert(ItemMapperImpl.convert(it))
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe {
                                Log.i("addToMovie: ", "")
                            }

                }
    }

}