package com.app.socialapp.di.components

import android.app.Application
import android.content.Context
import com.app.socialapp.application.MainApplication
import com.app.socialapp.di.ApplicationContext
import com.app.socialapp.di.modules.ApplicationModule
import com.app.socialapp.di.modules.ContextModule
import com.app.socialapp.di.modules.RetrofitModule
import com.app.socialapp.di.modules.RoomModule
import com.app.socialapp.mvp.ui.movieview.MoviePresenter
import com.app.socialapp.mvp.ui.movieview.MovieViewFragment
import com.app.socialapp.mvp.ui.searchview.SearchPresenter
import com.app.socialapp.mvp.ui.searchview.SearchView
import com.app.socialapp.mvp.ui.socialview.SocialPresenter
import com.app.socialapp.mvp.ui.socialview.SocialViewActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    RetrofitModule::class,
    ContextModule::class,
    ApplicationModule::class,
    RoomModule::class
])
interface AppComponent {
    @ApplicationContext
    fun context(): Context

    fun application(): Application

    fun inject(mainApp: MainApplication)

    fun inject(movieViewFragment: MovieViewFragment)

    fun inject(moviePresenter: MoviePresenter)

    fun inject(searchView: SearchView)

    fun inject(searchPresenter: SearchPresenter)

    fun inject(socialViewActivity: SocialViewActivity)

    fun inject(socialPresenter: SocialPresenter)
}