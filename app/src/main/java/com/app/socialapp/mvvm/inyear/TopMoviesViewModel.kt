package com.app.socialapp.mvvm.inyear

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.socialapp.adapter.TopMoviesTmdbAdapter
import com.app.socialapp.data.entities.tmdb.TopMovies
import com.app.socialapp.data.repository.remote.tmdb.TopMoviesRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class TopMoviesViewModel : ViewModel() {
    private val topMoviesRepository: TopMoviesRepository = TopMoviesRepository()
    var moviesData: MutableList<TopMoviesTmdbAdapter> = mutableListOf()
    var moviesLiveData: MutableLiveData<List<TopMoviesTmdbAdapter>> = MutableLiveData()

    init {
        loadDataInRecView()
    }

    private fun loadDataInRecView() {
        topMoviesRepository
                .getMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<List<TopMovies>> {

                    override fun onSuccess(t: List<TopMovies>) {
                        t.forEach {
                            it.results.forEach { itemMovie ->
                                moviesData.add(TopMoviesTmdbAdapter(itemMovie))
                            }
                        }

                        moviesLiveData.value = moviesData
                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onError(e: Throwable) {

                    }

                }
                )
    }

}