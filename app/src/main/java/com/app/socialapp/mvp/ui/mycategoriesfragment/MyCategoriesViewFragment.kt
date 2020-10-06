package com.app.socialapp.mvp.ui.mycategoriesfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.socialapp.R
import com.app.socialapp.application.MainApplication
import com.app.socialapp.fragment.BaseFragment

class MyCategoriesViewFragment : BaseFragment(), MyCategoriesContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainApplication.applicationComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_category, container, false)
        return view
    }

    override fun onResume() {
        super.onResume()
    }
}