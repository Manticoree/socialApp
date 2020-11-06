package com.app.socialapp.adapter.flexadapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.app.socialapp.R
import com.app.socialapp.adapter.TopMoviesBase
import com.app.socialapp.data.entities.tmdb.ItemMovie
import com.bumptech.glide.Glide
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.viewholders.FlexibleViewHolder
import kotlinx.android.synthetic.main.item_movies_tmdb.view.*

class TopMoviesTmdbAdapter(private val itemMovie: ItemMovie) :
        AbstractFlexibleItem<TopMoviesTmdbAdapter.MoviesHolder>(), TopMoviesBase {

    companion object {
        const val tmdbImageUrl = "https://image.tmdb.org/t/p/w500"
    }

    private val shimmer = Shimmer.AlphaHighlightBuilder()
            .setDuration(1800) // how long the shimmering animation takes to do one full sweep
            .setBaseAlpha(0.7f) //the alpha of the underlying children
            .setHighlightAlpha(0.6f) // the shimmer alpha amount
            .setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
            .setAutoStart(true)
            .build()
    val shimmerDrawable = ShimmerDrawable().apply {
        setShimmer(shimmer)
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
    ): MoviesHolder {
        return MoviesHolder(view, adapter)
    }

    override fun getLayoutRes(): Int = R.layout.item_movies_tmdb

    override fun hashCode(): Int = itemMovie.hashCode()


    inner class MoviesHolder(
            private val view: View,
            adapter: FlexibleAdapter<out IFlexible<*>>
    ) :
            FlexibleViewHolder(view, adapter) {

        fun bind(item: ItemMovie) {

            Glide.with(view)
                    .load(tmdbImageUrl + item.poster_path)
                    .error(view.context.getDrawable(R.drawable.ic_no_photography_24))
                    .into(itemView.sivMoviePoster)

            itemView.mtvTitleMovies.text = item.title
            itemView.mtvYear.text = item.release_date
            itemView.mtvLanguageMovies.text = item.original_language
        }

    }

}