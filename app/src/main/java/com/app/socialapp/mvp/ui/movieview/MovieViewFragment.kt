package com.app.socialapp.mvp.ui.movieview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.socialapp.R
import com.app.socialapp.application.MainApplication
import com.app.socialapp.fragment.BaseFragment

class MovieViewFragment : BaseFragment(), MovieContract.View {

    private var presenter: MovieContract.Presenter? = null

    companion object {
        private const val ARG_PAGE: String = "ARG_PAGE"
        fun newInstance(page: Int): MovieViewFragment {
            val args = Bundle()
            args.putInt(ARG_PAGE, page)
            val fragment = MovieViewFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainApplication.applicationComponent?.inject(this)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_social, container, false)
        if (presenter == null)
            presenter = MoviePresenter(this)
        return view
    }
}