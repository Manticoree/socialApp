package com.app.socialapp.data.entities.tmdb

import androidx.recyclerview.widget.RecyclerView
import com.app.socialapp.adapter.defaultadapter.topmovies.TopMoviesHolderFactory
import com.app.socialapp.data.entities.ItemManyHolderTopMovies

data class ItemYear(val year: String) : ItemManyHolderTopMovies {

    override fun getItemViewType(): Int = ItemManyHolderTopMovies.YEAR_TEXT

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder) {
        val yearHolder: TopMoviesHolderFactory.YearViewHolder = viewHolder as TopMoviesHolderFactory.YearViewHolder
        yearHolder.bind(this)
    }
}