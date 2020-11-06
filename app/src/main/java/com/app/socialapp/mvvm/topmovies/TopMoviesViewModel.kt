package com.app.socialapp.mvvm.topmovies

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.socialapp.data.entities.ItemManyHolderTopMovies
import com.app.socialapp.data.entities.tmdb.ItemTopMovies
import com.app.socialapp.data.entities.tmdb.ItemYear
import com.app.socialapp.data.repository.remote.tmdb.TopMoviesRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class TopMoviesViewModel : ViewModel() {
    private val topMoviesRepository: TopMoviesRepository = TopMoviesRepository()
    var moviesData: MutableList<ItemManyHolderTopMovies> = mutableListOf()
    var moviesLiveData: MutableLiveData<List<ItemManyHolderTopMovies>> = MutableLiveData()

    fun loadDataInRecView() {
        topMoviesRepository
                .getMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<List<ItemTopMovies>> {

                    override fun onSuccess(t: List<ItemTopMovies>) {

                        t.forEach {
                            Log.i("Log: ", it.toString())
                            val itemYear = ItemYear(it.results[0].release_date.substring(0, 4))
                            moviesData.add(itemYear)
                            moviesData.add(it)

                        }
                        moviesLiveData.value = moviesData
                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onError(e: Throwable) {

                    }

                })
    }

}