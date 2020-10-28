package com.app.socialapp.data.entities.imdb

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemMovieImdb(
        @SerializedName("Title") val title: String?,
        @SerializedName("Year") val year: Int,
        @SerializedName("Rated") val rated: String,
        @SerializedName("Released") val released: String,
        @SerializedName("Runtime") val runtime: String,
        @SerializedName("Genre") val genre: String,
        @SerializedName("Director") val director: String,
        @SerializedName("Writer") val writer: String,
        @SerializedName("Actors") val actors: String,
        @SerializedName("Plot") val plot: String,
        @SerializedName("Language") val language: String,
        @SerializedName("Country") val country: String,
        @SerializedName("Awards") val awards: String,
        /* @field:SerializedName("Ratings")  val rating: List<ItemRating>,*/
        @SerializedName("Poster") val poster: String) : Parcelable