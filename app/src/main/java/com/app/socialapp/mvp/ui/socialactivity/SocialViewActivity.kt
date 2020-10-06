package com.app.socialapp.mvp.ui.socialactivity

import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.app.socialapp.R
import com.app.socialapp.application.BaseActivity
import com.app.socialapp.application.MainApplication
import com.app.socialapp.mvp.ui.moviespagesfragment.MoviesPagesViewFragment
import com.app.socialapp.room.MoviesDao
import javax.inject.Inject

class SocialViewActivity() : BaseActivity(), SocialContract.View {

    var moviesDao: MoviesDao? = null
        @Inject set

    private var presenter: SocialContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social)
        MainApplication.applicationComponent.inject(this)
        if (presenter == null)
            presenter = SocialPresenter(this)
        presenter?.onShowMoviesFragment()
    }

    override fun showMoviesFragment() {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fcvFragment, MoviesPagesViewFragment())
        transaction.commit()
    }

    override fun onDestroy() {
        presenter = null
        super.onDestroy()
    }
}