package com.app.socialapp.mvp.ui.fragment.search

import android.util.Log
import com.app.socialapp.application.MainApplication
import com.app.socialapp.data.entities.imdb.ItemMovie
import com.app.socialapp.data.local.room.MoviesDao
import com.app.socialapp.data.remote.retrofit.ServiceImdb
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class SearchPresenter(
        val view: SearchContract.View
) : SearchContract.Presenter {

    @Inject
    lateinit var serviceImdb: ServiceImdb

    @Inject
    lateinit var moviesDao: MoviesDao

    companion object {
        const val IMBD_TOKEN: String = "9531f308"
    }

    override fun onClickSearch() {
        view.clickSearch()
    }

    override fun searchMovie(name: String) {
        MainApplication.applicationComponent.inject(this)
        Log.i("valueSearch ", "subserviceApi $serviceImdb")
        serviceImdb.getMovies(name, IMBD_TOKEN)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<ItemMovie> {

                    override fun onSubscribe(d: @NonNull Disposable) {
                        view.getDisposableList().add(d)
                    }

                    override fun onSuccess(itemMovie: ItemMovie) {
                        Log.i("valueSearch", itemMovie.toString())
                        if (itemMovie.title != null) {
                            moviesDao.insert(itemMovie)
                            view.showMovie(itemMovie.poster, itemMovie.title, itemMovie.plot)
                        }
                    }

                    override fun onError(e: @NonNull Throwable) {
                        Log.e("valueSearchE", e.localizedMessage)
                    }

                })
        Log.i("valueSearch ", "subserviceApi $serviceImdb")
    }

}


