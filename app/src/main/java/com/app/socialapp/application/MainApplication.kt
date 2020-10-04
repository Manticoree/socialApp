package com.app.socialapp.application

import androidx.multidex.MultiDexApplication
import com.app.socialapp.di.components.AppComponent
import com.app.socialapp.di.components.DaggerAppComponent
import com.app.socialapp.di.modules.ApplicationModule
import com.app.socialapp.di.modules.ContextModule
import com.app.socialapp.di.modules.RetrofitModule
import com.app.socialapp.di.modules.RoomModule
import com.app.socialapp.room.MoviesDao
import javax.inject.Inject

class MainApplication : MultiDexApplication() {

    var moviesDao: MoviesDao? = null
        @Inject set

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerAppComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .contextModule(ContextModule(this))
                .roomModule(RoomModule(this))
                .retrofitModule(RetrofitModule(this, "http://www.omdbapi.com"))
                .build()
        applicationComponent.inject(this)
    }

    companion object {

        lateinit var applicationComponent: AppComponent

    }
}