package com.app.socialapp.data.entities.db

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "item_news")
data class ItemMovieDb(
        @PrimaryKey @ColumnInfo(name = "idItem") val idItem: String,
        @ColumnInfo(name = "title") val title: String?,
        @ColumnInfo(name = "year") val year: Int,
        @ColumnInfo(name = "rated") val rated: String,
        @ColumnInfo(name = "released") val released: String,
        @ColumnInfo(name = "runtime") val runtime: String,
        @ColumnInfo(name = "genre") val genre: String,
        @ColumnInfo(name = "director") val director: String,
        @ColumnInfo(name = "writer") val writer: String,
        @ColumnInfo(name = "actors") val actors: String,
        @ColumnInfo(name = "plot") val plot: String,
        @ColumnInfo(name = "language") val language: String,
        @ColumnInfo(name = "country") val country: String,
        @ColumnInfo(name = "awards") val awards: String,
        /* @field:SerializedName("Ratings")  val rating: List<ItemRating>,*/
        @ColumnInfo(name = "poster") val poster: String) : Parcelable {

}