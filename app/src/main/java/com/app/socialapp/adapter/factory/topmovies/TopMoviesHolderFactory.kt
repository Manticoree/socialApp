package com.app.socialapp.adapter.factory.topmovies

import android.view.View
import com.app.socialapp.data.entities.ItemManyHolderTopMovies
import com.app.socialapp.data.entities.tmdb.ItemYear
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.viewholders.FlexibleViewHolder


class TopMoviesHolderFactory {

    inner class YearViewHolder(
            view: View,
            adapter: FlexibleAdapter<out IFlexible<*>>
    ) : FlexibleViewHolder(view, adapter) {
        fun bind(itemYear: ItemManyHolderTopMovies) {
            itemYear as ItemYear

        }

    }

}