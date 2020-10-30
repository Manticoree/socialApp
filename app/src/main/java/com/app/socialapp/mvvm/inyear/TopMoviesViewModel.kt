package com.app.socialapp.mvvm.inyear

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.socialapp.adapter.RecyclerTopMoviesTmdbAdapter
import com.app.socialapp.adapter.TopMoviesTmdbAdapter
import com.app.socialapp.data.entities.db.ItemTopMoviesDb
import com.app.socialapp.data.entities.tmdb.ItemTopMovies
import com.app.socialapp.data.repository.remote.tmdb.TopMoviesRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class TopMoviesViewModel : ViewModel() {
    private val topMoviesRepository: TopMoviesRepository = TopMoviesRepository()
    var moviesData: MutableList<RecyclerTopMoviesTmdbAdapter> = mutableListOf()
    var moviesLiveData: MutableLiveData<List<RecyclerTopMoviesTmdbAdapter>> = MutableLiveData()
    val listOfList: MutableList<List<ItemTopMoviesDb>> = mutableListOf()
    var listMoviesInYear: MutableList<TopMoviesTmdbAdapter> = mutableListOf()

    init {
        loadDataInRecView()
    }

    private fun loadDataInRecView() {
        topMoviesRepository
                .getMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<List<ItemTopMovies>> {

                    override fun onSuccess(t: List<ItemTopMovies>) {

                        listOfList.add(topMoviesRepository.getDbMovies(2020))
                        listOfList.add(topMoviesRepository.getDbMovies(2019))
                        // listOfList.add(topMoviesRepository.getDbMovies(2018))
                        // listOfList.add(topMoviesRepository.getDbMovies(2017))
                        // listOfList.add(topMoviesRepository.getDbMovies(2016))
                        listOfList.forEach {
                            it.forEach {
                                listMoviesInYear.add(TopMoviesTmdbAdapter(it))
                                moviesData.add(RecyclerTopMoviesTmdbAdapter(listMoviesInYear))
                            }
                        }

                        moviesLiveData.value = moviesData
                        /*
                        topMoviesRepository.getDbMovies(2020).forEach {
                            listMoviesInYear.add(TopMoviesTmdbAdapter(it))
                        }

                         */
                        /*
                        t.forEach {
                            it.results.forEach { itemMovie ->
                                moviesData.add(TopMoviesTmdbAdapter(itemMovie))
                            }
                        }

                        moviesLiveData.value = moviesData
                         */
                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onError(e: Throwable) {

                    }

                }
                )

    }

}