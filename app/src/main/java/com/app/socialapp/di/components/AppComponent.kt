package com.app.socialapp.di.components

import android.app.Application
import android.content.Context
import com.app.socialapp.application.MainApplication
import com.app.socialapp.di.ApplicationContext
import com.app.socialapp.di.modules.ApplicationModule
import com.app.socialapp.di.modules.ContextModule
import com.app.socialapp.di.modules.RetrofitModule
import com.app.socialapp.di.modules.RoomModule
import com.app.socialapp.mvp.ui.moviefragment.MoviePresenter
import com.app.socialapp.mvp.ui.moviefragment.MovieViewFragment
import com.app.socialapp.mvp.ui.moviespagesfragment.MoviesPagesPresenter
import com.app.socialapp.mvp.ui.moviespagesfragment.MoviesPagesViewFragment
import com.app.socialapp.mvp.ui.searchfragment.SearchPresenter
import com.app.socialapp.mvp.ui.searchfragment.SearchViewFragment
import com.app.socialapp.mvp.ui.socialactivity.SocialPresenter
import com.app.socialapp.mvp.ui.socialactivity.SocialViewActivity
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

    fun inject(searchViewFragment: SearchViewFragment)

    fun inject(searchPresenter: SearchPresenter)

    fun inject(socialViewActivity: SocialViewActivity)

    fun inject(socialPresenter: SocialPresenter)

    fun inject(moviesPagesPresenter: MoviesPagesPresenter)

    fun inject(moviesPagesViewFragment: MoviesPagesViewFragment)

}