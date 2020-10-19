package com.app.socialapp.mvp.ui.host.fragment.serials

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.socialapp.R
import com.app.socialapp.fragment.BaseFragment

class HostSerialsFragment : BaseFragment(), HostSerialsContract.View {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.fragment_serials_host, container, false)

}