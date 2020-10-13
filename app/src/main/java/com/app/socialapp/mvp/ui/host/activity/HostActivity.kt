package com.app.socialapp.mvp.ui.host.activity

import android.os.Bundle
import com.app.socialapp.R
import com.app.socialapp.application.BaseActivity

class HostActivity : BaseActivity(), HostContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host)
    }

}