package com.app.socialapp.domain.entities.tmdb

import com.app.socialapp.domain.entities.ItemManyHolderTopMovies

data class ItemYear(val year: String) : ItemManyHolderTopMovies {

    override fun getItemViewType(): Int = ItemManyHolderTopMovies.YEAR_TEXT

}