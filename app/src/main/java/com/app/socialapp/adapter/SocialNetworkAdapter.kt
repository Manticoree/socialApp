package com.app.socialapp.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.app.socialapp.R
import com.app.socialapp.entities.ItemNews
import com.bumptech.glide.Glide
import com.google.android.material.shape.CornerFamily
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.viewholders.FlexibleViewHolder
import kotlinx.android.synthetic.main.item_movies.view.*

class SocialNetworkAdapter(private val itemNews: ItemNews?) : AbstractFlexibleItem<SocialNetworkAdapter.MyViewHolder>() {

    override fun bindViewHolder(
            adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>?,
            holder: MyViewHolder?,
            position: Int,
            payloads: MutableList<Any>?
    ) {
        holder?.bind(itemNews)
    }

    override fun equals(other: Any?): Boolean {
        TODO("Not yet implemented")
    }

    override fun createViewHolder(
            view: View,
            adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>?
    ): MyViewHolder = MyViewHolder(view, adapter)

    override fun getLayoutRes(): Int = R.layout.item_movies

    inner class MyViewHolder(private val view: View, adapter: FlexibleAdapter<out IFlexible<*>>?) :
            FlexibleViewHolder(view, adapter) {

        fun bind(item: ItemNews?) {
            itemView.mtvTitleMovies.text = item?.title
            /*itemView.mtvRatingMovies.text = item?.rating?.get(0)?.value*/
            itemView.mtvPGMovies.text = item?.rated
            itemView.mtvGenreMovies.text = item?.genre
            itemView.mtvDirectorMovies.text = item?.director
            itemView.mtvWriterMovies.text = item?.writer
            itemView.mtvLanguageMovies.text = item?.language
            itemView.mtvCountryMovies.text = item?.country
            itemView.mtvAwardsMovies.text = item?.awards
            itemView.mtvDescriptionMovies.text = item?.plot
            changeShapeImageView()
            Glide
                    .with(view)
                    .load(item?.poster)
                    .into(itemView.sivMoviePoster)

        }

        fun changeShapeImageView() {
            itemView.sivMoviePoster.shapeAppearanceModel = itemView.sivMoviePoster.shapeAppearanceModel
                    .toBuilder()
                    .setTopRightCorner(CornerFamily.CUT, 200f)
                    .build()
        }
    }

}