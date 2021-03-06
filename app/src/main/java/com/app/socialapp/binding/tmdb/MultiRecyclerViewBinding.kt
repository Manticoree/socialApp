package com.app.socialapp.binding.tmdb

import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.socialapp.adapter.defaultadapter.MultiTopMoviesAdapter
import com.app.socialapp.domain.entities.ItemManyHolderTopMovies
import com.app.socialapp.extensions.gone
import com.app.socialapp.mvvm.movies.topmovies.TopMoviesViewModel

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>?) {
    view.adapter = adapter
}

@BindingAdapter("paginationMultiList")
fun paginationMultiList(view: RecyclerView, viewModel: TopMoviesViewModel) {

}

@BindingAdapter("adapterList")
fun bindAdapterMultiList(view: RecyclerView, multiList: List<ItemManyHolderTopMovies>?) {
    multiList?.let { (view.adapter as? MultiTopMoviesAdapter)?.addMoviesList(it) }
    view.apply {
        setHasFixedSize(true)
    }
}

@BindingAdapter("gone")
fun bindGone(view: ProgressBar, shouldBeGone: Boolean) {
    view.gone(shouldBeGone)
}