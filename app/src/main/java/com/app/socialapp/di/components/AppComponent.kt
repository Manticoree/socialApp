package com.app.socialapp.di.components

import android.app.Application
import android.content.Context
import com.app.socialapp.application.MainApplication
import com.app.socialapp.di.ApplicationContext
import com.app.socialapp.di.modules.ApplicationModule
import com.app.socialapp.di.modules.ContextModule
import com.app.socialapp.di.modules.RetrofitModule
import com.app.socialapp.di.modules.RoomModule
import com.app.socialapp.mvp.ui.fragment.movie.MovieFragment
import com.app.socialapp.mvp.ui.fragment.movie.MoviePresenter
import com.app.socialapp.mvp.ui.fragment.mycategories.MyCategoriesFragment
import com.app.socialapp.mvp.ui.fragment.mycategories.MyCategoriesPresenter
import com.app.socialapp.mvp.ui.fragment.search.SearchFragment
import com.app.socialapp.mvp.ui.fragment.search.SearchPresenter
import com.app.socialapp.mvp.ui.host.activity.HostActivity
import com.app.socialapp.mvp.ui.host.activity.HostPresenter
import com.app.socialapp.mvp.ui.host.fragment.HostFragment
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

    fun inject(movieFragment: MovieFragment)

    fun inject(moviePresenter: MoviePresenter)

    fun inject(searchFragment: SearchFragment)

    fun inject(searchPresenter: SearchPresenter)

    fun inject(hostActivity: HostActivity)

    fun inject(hostPresenter: HostPresenter)

    fun inject(hostPresenter: com.app.socialapp.mvp.ui.host.fragment.HostPresenter)

    fun inject(hostFragment: HostFragment)

    fun inject(myCategoriesPresenter: MyCategoriesPresenter)

    fun inject(myCategoriesFragment: MyCategoriesFragment)

}