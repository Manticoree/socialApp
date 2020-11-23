package com.app.socialapp.data.remote.retrofit

import com.app.socialapp.data.entities.tmdb.ItemTopMovies
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceTmdb {

    @GET("discover/movie")
    fun getTopMoviesInYears(
            @Query("primary_release_year") primaryRelease: String,
            @Query("api_key") api_key: String,
            @Query("page") page: Int,
    ): Single<ItemTopMovies>

    @GET("discover/movie")
    fun getHighestRatingMovies(
            @Query("certification_country") primaryRelease: String,
            @Query("certification") certification: String,
            @Query("api_key") api_key: String,
            @Query("page") page: Int,
    ): Single<ItemTopMovies>

    @GET("discover/movie")
    fun getPopularMovies(
            @Query("api_key") api_key: String,
            @Query("page") page: Int,
    ): Single<ItemTopMovies>

}