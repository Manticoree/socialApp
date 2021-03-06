package com.app.socialapp.mvp.ui.fragment.search

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.app.socialapp.R
import com.app.socialapp.base.MainApplication
import com.app.socialapp.fragment.BaseFragment
import com.bumptech.glide.Glide
import com.jakewharton.rxbinding4.view.clicks
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : BaseFragment(R.layout.fragment_search), SearchContract.View {

    lateinit var presenter: SearchContract.Presenter

    private var disList: MutableList<Disposable> = mutableListOf()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("LifecycleFragmentSearch", "attach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainApplication.applicationComponent.inject(this)
        Log.i("LifecycleFragmentSearch", "create")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("LifecycleFragmentSearch", "onViewCreated")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("LifecycleFragmentSearch", "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        presenter = SearchPresenter(this)
        presenter.onClickSearch()
        Log.i("LifecycleFragmentSearch", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("LifecycleFragmentSearch", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("LifecycleFragmentSearch", "onPause")
    }

    override fun onStop() {
        disList.forEach { it.dispose() }
        super.onStop()
        Log.i("LifecycleFragmentSearch", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("LifecycleFragmentSearch", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LifecycleFragmentSearch", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("LifecycleFragmentSearch", "onDetach")
    }

    override fun showMovie(
            moviePoster: String?,
            movieTitle: String?,
            movieDescription: String?
    ) {
        sivMoviePoster.visibility = View.VISIBLE
        mtvMoviesTitle.visibility = View.VISIBLE
        mtvDescription.visibility = View.VISIBLE
        mbtnAddInCollection.visibility = View.VISIBLE
        Glide
                .with(this)
                .load(moviePoster)
                .centerCrop()
                .into(sivMoviePoster)
        mtvMoviesTitle.text = movieTitle
        mtvDescription.text = movieDescription
    }

    override fun clickSearch() {
        disList.add(mbtnSearchMovie.clicks().subscribe {
            if (tietMovie.text.toString() != "") {
                presenter.searchMovie(tietMovie.text.toString())
            } else {
                Toast.makeText(activity, "Введите название фильма: ", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun getDisposableList(): MutableList<Disposable> {
        return disList
    }
}