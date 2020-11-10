package com.app.socialapp.data.entities.tmdb

import com.app.socialapp.data.entities.ItemManyHolderTopMovies

data class ItemYear(val year: String) : ItemManyHolderTopMovies {

    override fun getItemViewType(): Int = ItemManyHolderTopMovies.YEAR_TEXT

}