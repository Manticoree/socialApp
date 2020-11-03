package com.app.socialapp.data.entities

import androidx.recyclerview.widget.RecyclerView

interface ItemManyHolderTopMovies {
    companion object {
        const val YEAR_TEXT: Int = 0
        const val ITEM_RECVIEW: Int = 1
    }

    fun getItemViewType(): Int
    fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder)

}