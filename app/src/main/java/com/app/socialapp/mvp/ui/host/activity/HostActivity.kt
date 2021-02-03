package com.app.socialapp.mvp.ui.host.activity

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.app.socialapp.R
import com.app.socialapp.base.BaseActivity
import kotlinx.android.synthetic.main.activity_host.*

class HostActivity : BaseActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host)
        navController = Navigation.findNavController(this, R.id.fcvFragment)
        NavigationUI.setupWithNavController(btmNavigation, navController)
    }

}