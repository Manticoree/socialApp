package com.app.socialapp.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.socialapp.adapter.TopMoviesTmdbAdapter
import com.app.socialapp.data.RepositoryTmdb


class TopMoviesViewModel : ViewModel() {
    private val repositoryTmdb: RepositoryTmdb
    var moviesLiveData: MutableLiveData<List<TopMoviesTmdbAdapter>> = MutableLiveData()

    init {
        repositoryTmdb = RepositoryTmdb()
        moviesLiveData.value = repositoryTmdb.getMovies()
    }

}