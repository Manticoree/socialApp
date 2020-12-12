package com.app.socialapp.domain.entities.tmdb

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemMovie(
        val vote_average: String,
        val popularity: String,
        val vote_count: String,
        val adult: Boolean,
        val title: String,
        val release_date: String,
        val original_language: String,
        val overview: String,
        val poster_path: String
) : Parcelable