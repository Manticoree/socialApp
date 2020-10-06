package com.app.socialapp.mvp.ui.searchfragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.app.socialapp.R
import com.app.socialapp.application.MainApplication
import com.app.socialapp.fragment.BaseFragment
import com.app.socialapp.mvp.ui.moviespagesfragment.MoviesPagesViewFragment
import com.bumptech.glide.Glide
import com.jakewharton.rxbinding4.view.clicks
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_search.*

class SearchViewFragment : BaseFragment(), SearchContract.View {

    var presenter: SearchContract.Presenter? = null

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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_search, container, false)
        retainInstance = true
        Log.i("LifecycleFragmentSearch", "onCreateView")
        return view
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
        if (presenter == null)
            presenter = SearchPresenter(this)
        presenter?.onClickSearch()
        presenter?.onClickBack()
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
        presenter = null
        for (i in disList)
            i.dispose()
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

    override fun showMovie(moviePoster: String?, movieTitle: String?, movieDescription: String?) {
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
                presenter?.searchMovie(tietMovie.text.toString())
            } else {
                Toast.makeText(activity, "Введите название фильма: ", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun clickBack() {
        disList.add(mbtnBack.clicks().subscribe {
            presenter?.onBackToTheMoviesFragment()
        })
    }

    override fun backToTheMoviesFragment() {
        val transaction: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(
                R.id.fcvFragment,
                MoviesPagesViewFragment()
        )
                .commit()
    }

    override fun getDisposableList(): MutableList<Disposable> {
        return disList
    }
}