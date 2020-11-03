package com.app.socialapp.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.app.socialapp.R
import com.app.socialapp.data.entities.tmdb.ItemYear
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.viewholders.FlexibleViewHolder
import kotlinx.android.synthetic.main.item_movies_tmdb_year_production.view.*

class ShowYearAdapter(private val item: ItemYear) :
        AbstractFlexibleItem<ShowYearAdapter.YearsHolder>(), TopMoviesBase {

    override fun bindViewHolder(
            adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>?,
            holder: YearsHolder,
            position: Int,
            payloads: MutableList<Any>?
    ) {
        holder.bind(item)
    }

    override fun equals(other: Any?): Boolean {
        return if (other is ItemYear) {
            other == item
        } else {
            false
        }
    }

    override fun createViewHolder(
            view: View,
            adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>
    ): YearsHolder = YearsHolder(view, adapter)

    override fun getLayoutRes(): Int = R.layout.item_movies_tmdb_year_production

    override fun hashCode(): Int = item.hashCode()


    inner class YearsHolder(
            view: View,
            adapter: FlexibleAdapter<out IFlexible<*>>
    ) :
            FlexibleViewHolder(view, adapter) {

        fun bind(item: ItemYear) {
            itemView.mtvYearProduction.text = item.year.toString()
        }

    }

}