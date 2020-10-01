package com.app.socialapp.mvp.ui.movieview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.socialapp.R
import com.app.socialapp.adapter.SocialNetworkAdapter
import com.app.socialapp.application.MainApplication
import com.app.socialapp.fragment.BaseFragment
import eu.davidea.flexibleadapter.FlexibleAdapter
import kotlinx.android.synthetic.main.fragment_social.*

class MovieViewFragment : BaseFragment(), MovieContract.View {

    private var presenter: MovieContract.Presenter? = null
    private lateinit var adapter: FlexibleAdapter<SocialNetworkAdapter>

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

    override fun showRecyclerView(initList: List<SocialNetworkAdapter>) {
        rvListSource.setHasFixedSize(true)
        var manager: RecyclerView.LayoutManager = LinearLayoutManager(
                activity,
                LinearLayoutManager.VERTICAL,
                false
        )
        rvListSource.layoutManager = manager
        adapter = FlexibleAdapter(initList)
        rvListSource.adapter = adapter
    }

}