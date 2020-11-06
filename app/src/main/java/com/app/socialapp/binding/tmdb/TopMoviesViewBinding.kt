package com.app.socialapp.binding.tmdb

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.socialapp.adapter.flexadapter.TopMoviesTmdbAdapter
import com.app.socialapp.data.entities.tmdb.ItemTopMovies
import com.skydoves.whatif.whatIfNotNullOrEmpty
import eu.davidea.flexibleadapter.FlexibleAdapter

@BindingAdapter("adapterTopMovies")
fun bindAdapter(view: RecyclerView, adapter: FlexibleAdapter<TopMoviesTmdbAdapter>) {
    view.adapter = adapter
}

@BindingAdapter("adapterTopMoviesList")
fun bindAdapterMultiList(view: RecyclerView, multiList: List<ItemTopMovies>?) {
    multiList.whatIfNotNullOrEmpty {

    }

}