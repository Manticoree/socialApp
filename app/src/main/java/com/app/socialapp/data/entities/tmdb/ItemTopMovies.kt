package com.app.socialapp.data.entities.tmdb

import android.os.Parcelable
import androidx.recyclerview.widget.RecyclerView
import com.app.socialapp.adapter.defaultadapter.topmovies.TopMoviesHolderFactory
import com.app.socialapp.adapter.flexadapter.TopMoviesTmdbAdapter
import com.app.socialapp.data.entities.ItemManyHolderTopMovies
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ItemTopMovies(
        val page: Int,
        val total_results: Int,
        val total_pages: Int,
        val results: List<ItemMovie>
) : Parcelable, ItemManyHolderTopMovies {

    override fun getItemViewType(): Int = ItemManyHolderTopMovies.ITEM_RECVIEW

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder) {
        val recItem: TopMoviesHolderFactory.ItemMovieHolder = viewHolder as TopMoviesHolderFactory.ItemMovieHolder
        val listAdap: MutableList<TopMoviesTmdbAdapter> = mutableListOf()
        results.forEach {
            listAdap.add(TopMoviesTmdbAdapter(it))
        }
        recItem.bind(listAdap)
    }

}