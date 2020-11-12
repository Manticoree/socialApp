package com.app.socialapp.binding.tmdb

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.socialapp.adapter.defaultadapter.MultiTopMoviesAdapter
import com.app.socialapp.data.entities.ItemManyHolderTopMovies
import com.app.socialapp.mvvm.topmovies.TopMoviesViewModel

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

}