package com.app.socialapp.di.components

import android.app.Application
import android.content.Context
import com.app.socialapp.application.MainApplication
import com.app.socialapp.data.repository.db.ShowListMoviesRepository
import com.app.socialapp.data.repository.remote.imdb.SearchMoviesRepository
import com.app.socialapp.data.repository.remote.tmdb.TopMoviesRepository
import com.app.socialapp.di.ApplicationContext
import com.app.socialapp.di.modules.ApplicationModule
import com.app.socialapp.di.modules.ContextModule
import com.app.socialapp.di.modules.RetrofitModule
import com.app.socialapp.di.modules.RoomModule
import com.app.socialapp.mvp.ui.fragment.dialog.bottom.addcategory.AddCategoryPresenter
import com.app.socialapp.mvp.ui.fragment.movie.ListMovieFragment
import com.app.socialapp.mvp.ui.fragment.movie.ListMoviePresenter
import com.app.socialapp.mvp.ui.fragment.mycategories.MyCategoriesFragment
import com.app.socialapp.mvp.ui.fragment.mycategories.MyCategoriesPresenter
import com.app.socialapp.mvp.ui.fragment.search.SearchFragment
import com.app.socialapp.mvp.ui.fragment.search.SearchPresenter
import com.app.socialapp.mvp.ui.host.activity.HostActivity
import com.app.socialapp.mvp.ui.host.fragment.movies.HostMoviesFragment
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

    fun inject(listMovieFragment: ListMovieFragment)

    fun inject(listMoviePresenter: ListMoviePresenter)

    fun inject(searchFragment: SearchFragment)

    fun inject(searchPresenter: SearchPresenter)

    fun inject(hostActivity: HostActivity)

    fun inject(hostMoviesPresenter: com.app.socialapp.mvp.ui.host.fragment.movies.HostMoviesPresenter)

    fun inject(hostMoviesFragment: HostMoviesFragment)

    fun inject(myCategoriesPresenter: MyCategoriesPresenter)

    fun inject(myCategoriesFragment: MyCategoriesFragment)

    fun inject(addCategoryPresenter: AddCategoryPresenter)


    fun inject(topMoviesRepository: TopMoviesRepository)
    fun inject(searchMoviesRepository: SearchMoviesRepository)
    fun inject(showListMoviesRepository: ShowListMoviesRepository)


}