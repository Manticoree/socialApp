package com.app.socialapp.mvp.ui.searchview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.app.socialapp.R
import com.app.socialapp.application.MainApplication
import com.app.socialapp.fragment.BaseFragment
import com.bumptech.glide.Glide
import com.jakewharton.rxbinding4.view.clicks
import kotlinx.android.synthetic.main.fragment_search.*

class SearchViewFragment : BaseFragment(), SearchContract.View {


    var presenter: SearchContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainApplication.applicationComponent?.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_search, container, false)
        if (presenter == null)
            presenter = SearchPresenter(this)
        return view
    }

    override fun onResume() {
        super.onResume()
        presenter?.onClickSearch()
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
            /*
            val manager: FragmentManager = requireActivity().supportFragmentManager
            var fragment:SearchViewFragment = manager
             */
        }
    }

    override fun backToTheMoviesFragment() {

    }
}