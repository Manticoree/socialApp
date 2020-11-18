package com.app.socialapp.binding.tmdb

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.socialapp.adapter.defaultadapter.PopularMoviesAdapter
import com.app.socialapp.data.entities.tmdb.ItemTopMovies
import com.app.socialapp.mvvm.popularmovies.PopularMoviesViewModel

@BindingAdapter("adapterPopular")
fun bindPopularAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>?) {
    view.adapter = adapter
}

@BindingAdapter("paginationPopularList")
fun paginationPopularList(view: RecyclerView, viewModel: PopularMoviesViewModel) {

}

@BindingAdapter("adapterPopularList")
fun bindAdapterPopularList(view: RecyclerView, popularList: List<ItemTopMovies>?) {
    popularList?.let { (view.adapter as? PopularMoviesAdapter)?.addListItem(it[0].results) }
}