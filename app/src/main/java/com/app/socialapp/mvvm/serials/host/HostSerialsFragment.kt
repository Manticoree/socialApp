package com.app.socialapp.mvvm.serials.host

import com.app.socialapp.R
import com.app.socialapp.fragment.BaseFragment
import com.app.socialapp.ui.fragmentadapter.AdapterSerialHost
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_serials_host.*

class HostSerialsFragment : BaseFragment(R.layout.fragment_serials_host) {

    lateinit var adapterSerials: AdapterSerialHost
    var disList: MutableList<Disposable> = mutableListOf()

    override fun onStart() {
        super.onStart()
        showSerialFragment()
    }

    fun showSerialFragment() {
        adapterSerials = AdapterSerialHost(childFragmentManager, 1)
        vpSerials.adapter = adapterSerials
        tabDiffSerials.setupWithViewPager(vpSerials)
    }

}