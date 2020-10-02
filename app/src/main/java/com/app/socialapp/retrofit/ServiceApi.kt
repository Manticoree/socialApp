package com.app.socialapp.retrofit

import com.app.socialapp.entities.ItemNews
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {

    @GET("/")
    fun getMovies(@Query("t") movieName: String,
                  @Query("apikey") token: String)
            : Single<ItemNews>

}