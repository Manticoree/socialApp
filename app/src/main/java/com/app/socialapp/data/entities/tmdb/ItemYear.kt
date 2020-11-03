package com.app.socialapp.data.entities.tmdb

import androidx.recyclerview.widget.RecyclerView
import com.app.socialapp.data.entities.ItemManyHolderTopMovies

data class ItemYear(val year: Int) : ItemManyHolderTopMovies {

    override fun getItemViewType(): String = ItemManyHolderTopMovies.YEAR_TEXT

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder) {

    }
}