package com.app.socialapp.domain.remote.retrofit

import com.app.socialapp.domain.entities.imdb.ItemMovieImdb
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceImdb {

    @GET("/")
    fun getMovies(@Query("t") movieName: String,
                  @Query("apikey") token: String)
            : Single<ItemMovieImdb>

}