package com.app.socialapp.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.app.socialapp.R
import com.app.socialapp.data.entities.db.ItemMovieDb
import com.bumptech.glide.Glide
import com.google.android.material.shape.CornerFamily
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.viewholders.FlexibleViewHolder
import kotlinx.android.synthetic.main.item_movies_imdb.view.*

class MoviesImdbAdapter(private val itemMovieDb: ItemMovieDb?) : AbstractFlexibleItem<MoviesImdbAdapter.MyViewHolder>() {

    override fun bindViewHolder(
            adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>?,
            holder: MyViewHolder?,
            position: Int,
            payloads: MutableList<Any>?
    ) {
        holder?.bind(itemMovieDb)
    }

    override fun equals(other: Any?): Boolean {
        return if (other is ItemMovieDb) {
            other == itemMovieDb
        } else {
            false
        }
    }

    override fun createViewHolder(
            view: View,
            adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>?
    ): MyViewHolder = MyViewHolder(view, adapter)

    override fun getLayoutRes(): Int = R.layout.item_movies_imdb

    override fun hashCode(): Int = itemMovieDb?.hashCode() ?: 0


    inner class MyViewHolder(private val view: View, adapter: FlexibleAdapter<out IFlexible<*>>?) :
            FlexibleViewHolder(view, adapter) {

        fun bind(itemDb: ItemMovieDb?) {
            itemView.mtvTitleMovies.text = itemDb?.title
            itemView.mtvYearMovies.text = itemDb?.year.toString()
            itemView.mtvRuntimeMovies.text = itemDb?.runtime
            /*itemView.mtvRatingMovies.text = item?.rating?.get(0)?.value*/
            itemView.mtvPGMovies.text = itemDb?.rated
            itemView.mtvGenreMovies.text = itemDb?.genre
            itemView.mtvDirectorMovies.text = itemDb?.director
            itemView.mtvWriterMovies.text = itemDb?.writer
            itemView.mtvLanguageMovies.text = itemDb?.language
            itemView.mtvCountryMovies.text = itemDb?.country
            itemView.mtvAwardsMovies.text = itemDb?.awards
            itemView.mtvDescriptionMovies.text = itemDb?.plot
            changeShapeImageView()
            Glide
                    .with(view)
                    .load(itemDb?.poster)
                    .into(itemView.sivMoviePoster)

        }

        private fun changeShapeImageView() {
            itemView.sivMoviePoster.shapeAppearanceModel = itemView.sivMoviePoster.shapeAppearanceModel
                    .toBuilder()
                    .setTopRightCorner(CornerFamily.CUT, 200f)
                    .build()
        }

    }

}