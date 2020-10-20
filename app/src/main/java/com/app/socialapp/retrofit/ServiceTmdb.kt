package com.app.socialapp.retrofit

import com.app.socialapp.entities.tmdb.ItemMovie
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceTmdb {

    @GET("/discover/movie")
    fun getTopMoviesInYears(
            @Query("primary_release_year") primaryRelease: String,
            @Query("sort_by") sort_by: String,
            @Query("api_key") api_key: String
    ): Single<ItemMovie>


}