package com.app.socialapp.data.entities.tmdb

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class TopMovies(
        val page: Int,
        val total_results: Int,
        val total_pages: Int,
        val results: List<ItemMovie>
) : Parcelable