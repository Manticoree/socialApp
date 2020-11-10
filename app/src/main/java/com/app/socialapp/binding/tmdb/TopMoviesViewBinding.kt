package com.app.socialapp.binding.tmdb

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.socialapp.adapter.defaultadapter.TopMoviesTmdbAdapter
import com.app.socialapp.data.entities.tmdb.ItemMovie
import com.skydoves.whatif.whatIfNotNullOrEmpty

@BindingAdapter("adapterTopMovies")
fun bindTopAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("adapterTopMoviesList")
fun bindAdapterTopList(view: RecyclerView, topList: List<ItemMovie>?) {
    topList.whatIfNotNullOrEmpty {
        (view.adapter as? TopMoviesTmdbAdapter)?.addListItem(it)
    }

}