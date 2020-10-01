package com.app.socialapp.mvp.ui.socialview

import android.os.Bundle
import com.app.socialapp.R
import com.app.socialapp.application.BaseActivity
import com.app.socialapp.application.MainApplication
import com.app.socialapp.mvp.fragmentadapter.AdapterSocial
import kotlinx.android.synthetic.main.activity_social.*

class SocialViewActivity() : BaseActivity(), SocialContract.View {

    private var presenter: SocialContract.Presenter? = null
    private var adapter: AdapterSocial? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social)
        MainApplication.applicationComponent?.inject(this)
        if (presenter == null)
            presenter = SocialPresenter(this)
        presenter?.onShowMoviesFragment()
    }

    override fun showMoviesFragment() {
        if (adapter == null) {
            adapter = AdapterSocial(supportFragmentManager, 1)
        }

        vpSocial.adapter = adapter
        tabDiffSocial.setupWithViewPager(vpSocial)

    }
}