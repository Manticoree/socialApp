package com.app.socialapp.di.modules

import android.content.Context
import com.app.socialapp.retrofit.ServiceApi
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RetrofitModule(private val context: Context, private val baseUrl: String) {
    private lateinit var retrofit: Retrofit

    @Provides
    fun getServiceApi(): ServiceApi {
        return getClient(context, baseUrl).create(ServiceApi::class.java)
    }

    @Provides
    fun getClient(context: Context, baseUrl: String): Retrofit {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        retrofit = Retrofit.Builder().baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
                //.client(getUnsafeOkHttpClient(context))
                .build()
        return retrofit
    }

}