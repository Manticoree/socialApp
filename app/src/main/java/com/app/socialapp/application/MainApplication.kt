package com.app.socialapp.application

import androidx.multidex.MultiDexApplication
import com.app.socialapp.di.components.AppComponent
import com.app.socialapp.di.components.DaggerAppComponent
import com.app.socialapp.di.modules.ApplicationModule
import com.app.socialapp.di.modules.ContextModule
import com.app.socialapp.di.modules.RetrofitModule
import org.jetbrains.annotations.Contract

class MainApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerAppComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .contextModule(ContextModule(this))
                .retrofitModule(RetrofitModule(this, "http://www.omdbapi.com/"))
                .build()
        applicationComponent!!.inject(this)
    }

    companion object {
        @get:Contract(pure = true)
        var applicationComponent: AppComponent? = null
            private set
    }
}