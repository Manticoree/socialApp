package com.app.socialapp.mvp.ui.socialview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction
import com.app.socialapp.R
import com.app.socialapp.application.BaseActivity
import com.app.socialapp.application.MainApplication
import com.app.socialapp.mvp.fragmentadapter.AdapterSocial
import com.app.socialapp.mvp.ui.searchview.SearchViewFragment
import com.app.socialapp.room.MoviesDao
import com.jakewharton.rxbinding4.view.clicks
import kotlinx.android.synthetic.main.activity_social.*
import javax.inject.Inject

class SocialViewActivity() : BaseActivity(), SocialContract.View {

    var moviesDao: MoviesDao? = null
        @Inject set

    private var presenter: SocialContract.Presenter? = null
    private var adapter: AdapterSocial? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social)
        MainApplication.applicationComponent?.inject(this)
        if (presenter == null)
            presenter = SocialPresenter(this)
        presenter?.onShowMoviesFragment()
        presenter?.onGoToTeSearchView()
    }

    override fun showMoviesFragment() {
        fcvFragment.visibility = View.GONE
        abTitleList.visibility = View.VISIBLE
        vpSocial.visibility = View.VISIBLE
        fabAddMovies.visibility = View.VISIBLE
        if (adapter == null) {
            adapter = AdapterSocial(supportFragmentManager, 1)
        }
        vpSocial.adapter = adapter
        tabDiffSocial.setupWithViewPager(vpSocial)
    }

    override fun goToTheSearchView() {
        fabAddMovies.clicks().subscribe {
            presenter?.onShowSearchFragment()
        }
    }

    override fun showSearchFragment() {
        fcvFragment.visibility = View.VISIBLE
        abTitleList.visibility = View.GONE
        vpSocial.visibility = View.GONE
        fabAddMovies.visibility = View.GONE
        var fTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fTransaction.add(R.id.fcvFragment, SearchViewFragment())
        fTransaction.commit()
    }
}