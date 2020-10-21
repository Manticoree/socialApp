package com.app.socialapp.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.app.socialapp.R
import com.app.socialapp.data.entities.tmdb.ItemMovie
import com.bumptech.glide.Glide
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.viewholders.FlexibleViewHolder
import kotlinx.android.synthetic.main.item_movies_tmdb.view.*

class TopMoviesTmdbAdapter(private val itemMovie: ItemMovie) :
        AbstractFlexibleItem<TopMoviesTmdbAdapter.MoviesHolder>() {

    companion object {
        const val tmdbImageUrl = "https://image.tmdb.org/t/p/w500"
    }

    override fun bindViewHolder(
            adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>?,
            holder: MoviesHolder,
            position: Int,
            payloads: MutableList<Any>?
    ) {

        holder.bind(itemMovie)
    }

    override fun equals(other: Any?): Boolean {
        return if (other is ItemMovie) {
            other == itemMovie
        } else {
            false
        }
    }

    override fun createViewHolder(
            view: View,
            adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>
    ): MoviesHolder = MoviesHolder(view, adapter)

    override fun getLayoutRes(): Int = R.layout.item_movies_tmdb

    override fun hashCode(): Int {
        return itemMovie.hashCode()
    }

    inner class MoviesHolder(
            private val view: View,
            adapter: FlexibleAdapter<out IFlexible<*>>
    ) :
            FlexibleViewHolder(view, adapter) {

        fun bind(item: ItemMovie) {
            Glide.with(view)
                    .load(tmdbImageUrl + item.poster_path)
                    .into(itemView.sivMoviePoster)
            itemView.mtvTitleMovies.text = item.title
            itemView.mtvYear.text = item.release_date
            itemView.mtvLanguageMovies.text = item.original_language
            itemView.mtvDescription.text = item.overview
        }

    }

}