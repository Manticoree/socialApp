package com.app.socialapp.data.entities

interface ItemManyHolderTopMovies {
    companion object {
        const val YEAR_TEXT: Int = 0
        const val ITEM_RECVIEW: Int = 1
    }

    fun getItemViewType(): Int

}