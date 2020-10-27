package com.app.socialapp.data.entities.imdb

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemMovieImdb(
        val title: String?,
        val year: Int,
        val rated: String,
        val released: String,
        val runtime: String,
        val genre: String,
        val director: String,
        val writer: String,
        val actors: String,
        val plot: String,
        val language: String,
        val country: String,
        val awards: String,
        /* @field:SerializedName("Ratings")  val rating: List<ItemRating>,*/
        val poster: String) : Parcelable