package com.app.socialapp.binding.tmdb

import androidx.databinding.BindingAdapter
import com.app.socialapp.R
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView

@BindingAdapter("loadFullImage")
fun bindLoadFullImage(view: ShapeableImageView, url: String?) {
    Glide.with(view)
            .load(url)
            .error(view.context.getDrawable(R.drawable.ic_no_photography_24))
            .into(view)
}