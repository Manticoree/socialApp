package com.app.socialapp.di.modules

import com.app.socialapp.retrofit.ServiceImdb
import com.app.socialapp.retrofit.ServiceTmdb
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule(val baseUrlImdb: String, val baseUrlTmdb: String) {

    lateinit var retrofit: Retrofit

    @Provides
    @Singleton
    fun getServiceImdb(): ServiceImdb {
        return getClient(baseUrlImdb).create(ServiceImdb::class.java)
    }

    @Provides
    @Singleton
    fun getServiceTmdb(): ServiceTmdb {
        return getClient(baseUrlTmdb).create(ServiceTmdb::class.java)
    }

    @Provides
    @Singleton
    fun getClient(baseUrl: String): Retrofit {
        val gsonBuilder = GsonBuilder()
        retrofit = Retrofit.Builder().baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
                .client(OkHttpClient.Builder().build())
                .build()
        return retrofit
    }


}