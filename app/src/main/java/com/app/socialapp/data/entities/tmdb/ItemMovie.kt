package com.app.socialapp.data.entities.tmdb

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemMovie(
        val vote_average: Float,
        val popularity: Float,
        val vote_count: Int,
        val adult: Boolean,
        val title: String,
        val release_date: String,
        val original_language: String,
        val overview: String,
        val poster_path: String
) : Parcelable