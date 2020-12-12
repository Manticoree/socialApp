package com.app.socialapp.application

import androidx.multidex.MultiDexApplication
import com.app.socialapp.di.components.AppComponent
import com.app.socialapp.di.components.DaggerAppComponent
import com.app.socialapp.di.modules.ApplicationModule
import com.app.socialapp.di.modules.ContextModule
import com.app.socialapp.di.modules.RetrofitModule
import com.app.socialapp.di.modules.RoomModule
import com.app.socialapp.domain.local.room.MoviesDao
import javax.inject.Inject

class MainApplication : MultiDexApplication() {

    @Inject
    lateinit var moviesDao: MoviesDao

    companion object {
        lateinit var applicationComponent: AppComponent
        const val IMDB_API = "http://www.omdbapi.com"
        const val TMDB_API = "http://api.themoviedb.org/3/"
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerAppComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .contextModule(ContextModule(this))
                .roomModule(RoomModule(this))
                .retrofitModule(RetrofitModule(IMDB_API, TMDB_API))
                .build()
        applicationComponent.inject(this)
    }

}