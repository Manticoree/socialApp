package com.app.socialapp.mvp.ui.searchfragment

import android.util.Log
import com.app.socialapp.application.MainApplication
import com.app.socialapp.entities.ItemNews
import com.app.socialapp.retrofit.ServiceApi
import com.app.socialapp.room.MoviesDao
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class SearchPresenter(
        val view: SearchContract.View
) : SearchContract.Presenter {

    var serviceApi: ServiceApi? = null
        @Inject set

    var moviesDao: MoviesDao? = null
        @Inject set

    companion object {
        const val IMBD_TOKEN: String = "9531f308"
    }

    override fun onClickSearch() {
        view.clickSearch()
    }

    override fun searchMovie(name: String) {
        MainApplication.applicationComponent.inject(this)
        Log.i("valueSearch ", "sub" + "serviceApi " + serviceApi.toString())
        serviceApi?.getMovies(name, IMBD_TOKEN)
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(object : SingleObserver<ItemNews> {
                    override fun onSubscribe(d: @NonNull Disposable) {

                    }

                    override fun onSuccess(itemNews: ItemNews) {
                        Log.i("valueSearch", itemNews.toString())
                        if (itemNews.title != null) {
                            moviesDao?.insert(itemNews)
                            view.showMovie(itemNews.poster, itemNews.title, itemNews.plot)
                        }
                    }

                    override fun onError(e: @NonNull Throwable) {
                        Log.e("valueSearchE", e.localizedMessage)
                    }
                })
        Log.i("valueSearch ", "sub" + "serviceApi " + serviceApi.toString())
    }

    override fun onClickBack() {
        view.clickBack()
    }

    override fun onBackToTheMoviesFragment() {
        view.backToTheMoviesFragment()
    }
}


