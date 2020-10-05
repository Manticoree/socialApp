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
import kotlinx.android.synthetic.main.fragment_search.*

class SearchViewFragment : BaseFragment(), SearchContract.View {


    var presenter: SearchContract.Presenter? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("LifecycleFragment: ", "attach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainApplication.applicationComponent?.inject(this)
        Log.i("LifecycleFragment: ", "create")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_search, container, false)
        if (presenter == null)
            presenter = SearchPresenter(this)
        Log.i("LifecycleFragment: ", "onCreateView")
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.onClickSearch()
        presenter?.onClickBack()
        Log.i("LifecycleFragment: ", "onViewCreated")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("LifecycleFragment: ", "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.i("LifecycleFragment: ", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("LifecycleFragment: ", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("LifecycleFragment: ", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("LifecycleFragment: ", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("LifecycleFragment: ", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LifecycleFragment: ", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("LifecycleFragment: ", "onDetach")
    }

    override fun showMovie(moviePoster: String?, movieTitle: String?, movieDescription: String?) {
        sivMoviePoster.visibility = View.VISIBLE
        mtvMoviesTitle.visibility = View.VISIBLE
        mtvDescription.visibility = View.VISIBLE
        Glide
                .with(this)
                .load(moviePoster)
                .centerCrop()
                .into(sivMoviePoster)
        mtvMoviesTitle.text = movieTitle
        mtvDescription.text = movieDescription
    }

    override fun clickSearch() {
        mbtnSearchMovie.clicks().subscribe {
            if (tietMovie.text.toString() != "") {
                presenter?.searchMovie(tietMovie.text.toString())
            } else {
                Toast.makeText(activity, "Введите название фильма: ", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun clickBack() {
        mbtnBack.clicks().subscribe {
            presenter?.onBackToTheMoviesFragment()
        }
    }

    override fun backToTheMoviesFragment() {
        val transaction: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fcvFragment, MoviesPagesViewFragment())

        transaction.commit()
    }
}