package com.app.socialapp.binding.tmdb

import androidx.databinding.BindingAdapter
import com.app.socialapp.R
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView

const val tmdbImageUrl = "https://image.tmdb.org/t/p/w500"

@BindingAdapter("loadImage")
fun bindLoadImage(view: ShapeableImageView, url: String?) {
    Glide.with(view)
            .load(tmdbImageUrl + url)
            .error(view.context.getDrawable(R.drawable.ic_no_photography_24))
            .into(view)
}