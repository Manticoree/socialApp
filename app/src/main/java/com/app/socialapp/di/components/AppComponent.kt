package com.app.socialapp.di.components

import android.app.Application
import android.content.Context
import com.app.socialapp.application.MainApplication
import com.app.socialapp.di.ApplicationContext
import com.app.socialapp.di.modules.RetrofitModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class])
interface AppComponent {
    @ApplicationContext
    fun context(): Context?

    fun application(): Application?

    fun inject(mainApp: MainApplication?)
}