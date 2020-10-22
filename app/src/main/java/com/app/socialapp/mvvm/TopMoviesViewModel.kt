package com.app.socialapp.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.socialapp.adapter.TopMoviesTmdbAdapter
import com.app.socialapp.data.RepositoryTmdb
import com.app.socialapp.data.entities.tmdb.TopMovies
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class TopMoviesViewModel : ViewModel() {
    private val repositoryTmdb: RepositoryTmdb = RepositoryTmdb()
    var moviesData: MutableList<TopMoviesTmdbAdapter> = mutableListOf()
    var moviesLiveData: MutableLiveData<List<TopMoviesTmdbAdapter>> = MutableLiveData()

    init {
        loadDataInRecView()
    }

    private fun loadDataInRecView() {
        repositoryTmdb
                .getMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<TopMovies> {
                    override fun onSuccess(t: TopMovies) {
                        for (item in t.results) {
                            moviesData.add(TopMoviesTmdbAdapter(item))
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