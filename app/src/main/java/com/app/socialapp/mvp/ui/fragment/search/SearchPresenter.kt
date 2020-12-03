package com.app.socialapp.mvp.ui.fragment.search

import android.util.Log
import com.app.socialapp.application.MainApplication
import com.app.socialapp.data.entities.imdb.ItemMovieImdb
import com.app.socialapp.data.local.room.MoviesDao
import com.app.socialapp.data.remote.retrofit.ServiceImdb
import com.app.socialapp.data.repository.remote.imdb.SearchMoviesRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class SearchPresenter(
        val view: SearchContract.View,
        private val searchMoviesRepository: SearchMoviesRepository = SearchMoviesRepository()
) : SearchContract.Presenter {

    @Inject
    lateinit var serviceImdb: ServiceImdb

    @Inject
    lateinit var moviesDao: MoviesDao

    override fun onClickSearch() {
        view.clickSearch()
    }

    override fun searchMovie(name: String) {
        MainApplication.applicationComponent.inject(this)
        Log.i("valueSearch ", "subserviceApi $serviceImdb")
        searchMoviesRepository.getMovie(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<ItemMovieImdb> {

                    override fun onSubscribe(d: @NonNull Disposable) {
                        view.getDisposableList().add(d)
                    }

                    override fun onSuccess(itemMovieImdb: ItemMovieImdb) {
                        Log.i("valueSearch", itemMovieImdb.toString())
                        if (itemMovieImdb.title != null) {
                            view.showMovie(itemMovieImdb.poster, itemMovieImdb.title, itemMovieImdb.plot)
                        }
                    }

                    override fun onError(e: Throwable) {
                        Log.e("valueSearchE", e.localizedMessage)
                    }

                })
        Log.i("valueSearch ", "subserviceApi $serviceImdb")
    }

}


