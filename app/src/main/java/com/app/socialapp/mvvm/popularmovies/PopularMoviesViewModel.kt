package com.app.socialapp.mvvm.popularmovies

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.socialapp.data.entities.tmdb.ItemTopMovies
import com.app.socialapp.data.repository.remote.tmdb.PopularMoviesRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers


class PopularMoviesViewModel : ViewModel() {
    private val popularMoviesRepository: PopularMoviesRepository = PopularMoviesRepository()
    var popularMoviesData: MutableList<ItemTopMovies> = mutableListOf()
    var popularMoviesLiveData: MutableLiveData<List<ItemTopMovies>> = MutableLiveData()

    lateinit var disPopularMovies: Disposable

    fun loadPopularMovies() {
        popularMoviesRepository
                .getPopularMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<ItemTopMovies> {

                    override fun onSuccess(t: ItemTopMovies) {
                        popularMoviesData = mutableListOf(t)
                        if (popularMoviesLiveData.value.isNullOrEmpty())
                            popularMoviesLiveData.value = popularMoviesData
                    }

                    override fun onSubscribe(d: Disposable) {
                        disPopularMovies = d
                    }

                    override fun onError(e: Throwable) {
                        Log.e("onError popMov: ", e.fillInStackTrace().toString())
                    }

                })
    }

}