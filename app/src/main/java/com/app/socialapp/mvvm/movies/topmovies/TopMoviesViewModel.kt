package com.app.socialapp.mvvm.movies.topmovies

import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.socialapp.domain.entities.ItemManyHolderTopMovies
import com.app.socialapp.domain.entities.tmdb.ItemTopMovies
import com.app.socialapp.domain.entities.tmdb.ItemYear
import com.app.socialapp.domain.repository.remote.tmdb.TopMoviesRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class TopMoviesViewModel : ViewModel() {
    private val topMoviesRepository: TopMoviesRepository = TopMoviesRepository()
    var moviesData: MutableList<ItemManyHolderTopMovies> = mutableListOf()
    var moviesLiveData: MutableLiveData<List<ItemManyHolderTopMovies>> = MutableLiveData()

    val isLoadingProgressBar: ObservableBoolean = ObservableBoolean(false)

    lateinit var disTopMovies: Disposable

    fun loadDataInRecView() {
        Log.i("onViewCreated: ", "loadData")
        topMoviesRepository
                .getMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { isLoadingProgressBar.set(true) }
                .doOnSuccess { isLoadingProgressBar.set(false) }
                .doOnError { isLoadingProgressBar.set(false) }
                .subscribe(object : SingleObserver<List<ItemTopMovies>> {

                    override fun onSuccess(t: List<ItemTopMovies>) {
                        t.forEach {
                            Log.i("item movie year ", it.toString())
                            it.results.forEach {
                                Log.i("item movie ", it.toString())
                            }
                            val itemYear = ItemYear(it.results[0].release_date.substring(0, 4))
                            moviesData.add(itemYear)
                            moviesData.add(it)
                        }

                        if (moviesLiveData.value.isNullOrEmpty())
                            moviesLiveData.value = moviesData

                    }

                    override fun onSubscribe(d: Disposable) {
                        disTopMovies = d
                    }

                    override fun onError(e: Throwable) {
                        Log.e("onError load data: ", e.fillInStackTrace().toString())
                    }

                })
    }

    fun clearSession() {
        disTopMovies.dispose()
    }

}