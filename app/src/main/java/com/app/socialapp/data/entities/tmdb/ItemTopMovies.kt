package com.app.socialapp.data.entities.tmdb

import android.os.Parcelable
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

}