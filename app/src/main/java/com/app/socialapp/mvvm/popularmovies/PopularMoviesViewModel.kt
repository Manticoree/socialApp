package com.app.socialapp.mvvm.popularmovies

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.socialapp.domain.entities.tmdb.ItemTopMovies
import com.app.socialapp.domain.repository.remote.tmdb.PopularMoviesRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers


class PopularMoviesViewModel : ViewModel() {
    private val popularMoviesRepository: PopularMoviesRepository = PopularMoviesRepository()
    var popularMoviesLiveData: MutableLiveData<List<ItemTopMovies>> = MutableLiveData()
    var highestMoviesLiveData: MutableLiveData<List<ItemTopMovies>> = MutableLiveData()

    lateinit var disPopularMovies: Disposable
    lateinit var disHighestMovies: Disposable

    fun loadPopularMovies() {
        popularMoviesRepository
                .getPopularMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<ItemTopMovies> {

                    override fun onSuccess(t: ItemTopMovies) {
                        popularMoviesLiveData.value = mutableListOf(t)
                    }

                    override fun onSubscribe(d: Disposable) {
                        disPopularMovies = d
                    }

                    override fun onError(e: Throwable) {
                        Log.e("onError popMov: ", e.fillInStackTrace().toString())
                    }

                })
    }

    fun loadHighestMovies() {
        popularMoviesRepository
                .getHighestMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<ItemTopMovies> {

                    override fun onSuccess(t: ItemTopMovies) {
                        highestMoviesLiveData.value = mutableListOf(t)
                    }

                    override fun onSubscribe(d: Disposable) {
                        disHighestMovies = d
                    }

                    override fun onError(e: Throwable) {
                        Log.e("onError popMov: ", e.fillInStackTrace().toString())
                    }

                })
    }

}