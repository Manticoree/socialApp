package com.app.socialapp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class ItemNews(
        @field:PrimaryKey val idItem: Long,
        @field:SerializedName("Title") val title: String,
        @field:SerializedName("Year") val year: Int,
        @field:SerializedName("Rated") val rated: String,
        @field:SerializedName("Released") val released: String,
        @field:SerializedName("Runtime") val runtime: String,
        @field:SerializedName("Genre") val genre: String,
        @field:SerializedName("Director") val director: String,
        @field:SerializedName("Writer") val writer: String,
        @field:SerializedName("Actors") val actors: String,
        @field:SerializedName("Plot") val plot: String,
        @field:SerializedName("Language") val language: String,
        @field:SerializedName("Country") val country: String,
        @field:SerializedName("Awards") val awards: String,
        @field:SerializedName("Ratings") val rating: ItemRating,
        @field:SerializedName("Poster") val poster: String) : Serializable