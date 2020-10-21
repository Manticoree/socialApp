package com.app.socialapp.data.entities.imdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "item_news")
data class ItemMovie(
        @field:PrimaryKey(autoGenerate = true) @ColumnInfo(name = "idItem") val idItem: Long,
        @field:SerializedName("Title") @ColumnInfo(name = "title") val title: String?,
        @field:SerializedName("Year") @ColumnInfo(name = "year") val year: Int,
        @field:SerializedName("Rated") @ColumnInfo(name = "rated") val rated: String,
        @field:SerializedName("Released") @ColumnInfo(name = "released") val released: String,
        @field:SerializedName("Runtime") @ColumnInfo(name = "runtime") val runtime: String,
        @field:SerializedName("Genre") @ColumnInfo(name = "genre") val genre: String,
        @field:SerializedName("Director") @ColumnInfo(name = "director") val director: String,
        @field:SerializedName("Writer") @ColumnInfo(name = "writer") val writer: String,
        @field:SerializedName("Actors") @ColumnInfo(name = "actors") val actors: String,
        @field:SerializedName("Plot") @ColumnInfo(name = "plot") val plot: String,
        @field:SerializedName("Language") @ColumnInfo(name = "language") val language: String,
        @field:SerializedName("Country") @ColumnInfo(name = "country") val country: String,
        @field:SerializedName("Awards") @ColumnInfo(name = "awards") val awards: String,
        /* @field:SerializedName("Ratings")  val rating: List<ItemRating>,*/
        @field:SerializedName("Poster") @ColumnInfo(name = "poster") val poster: String) : Serializable