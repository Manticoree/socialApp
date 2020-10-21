package com.app.socialapp.data.entities.tmdb

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemMovie(
        val vote_average: Int,
        val title: String,
        val release_date: String,
        val original_language: String,
        val overview: String,
        val poster_path: String
) : Parcelable