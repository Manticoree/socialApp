package com.app.socialapp.mvp.ui.fragment.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.socialapp.R
import com.app.socialapp.adapter.MoviesImdbAdapter
import com.app.socialapp.fragment.BaseFragment
import eu.davidea.flexibleadapter.FlexibleAdapter
import kotlinx.android.synthetic.main.fragment_list.*

class ListMovieFragment : BaseFragment(), ListMovieContract.View {

    private var presenter: ListMovieContract.Presenter? = null
    private var imdbAdapter: FlexibleAdapter<MoviesImdbAdapter>? = null

    companion object {
        private const val ARG_PAGE: String = "ARG_PAGE"
        fun newInstance(page: Int): ListMovieFragment {
            val args = Bundle()
            args.putInt(ARG_PAGE, page)
            val fragment = ListMovieFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_list, container, false)
        retainInstance = true
        Log.i("LifecycleFragmentMovie", "onCreateView")
        return view
    }

    override fun onStart() {
        super.onStart()
        Log.i("LifecycleFragmentMovie", "onStart")
        if (presenter == null)
            presenter = ListMoviePresenter(this)
        presenter?.onShowRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        Log.i("LifecycleFragmentMovie", "onResume")

    }

    override fun onPause() {
        Log.i("LifecycleFragmentMovie", "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.i("LifecycleFragmentMovie", "onStop")
        presenter?.cleanMemory()
        presenter = null
        imdbAdapter = null
        super.onStop()
    }

    override fun showRecyclerView(initList: List<MoviesImdbAdapter>) {
        Log.i("initList: ", initList.toString())
        rvListSource.setHasFixedSize(true)
        val manager: RecyclerView.LayoutManager = LinearLayoutManager(
                activity,
                LinearLayoutManager.VERTICAL,
                false
        )
        rvListSource.layoutManager = manager
        imdbAdapter = FlexibleAdapter(initList)
        rvListSource.adapter = imdbAdapter
    }

}


