package com.app.socialapp.domain.entities.db

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "top_movies")
data class ItemTopMoviesDb(
        @ColumnInfo(name = "vote_average") val vote_average: String,
        @ColumnInfo(name = "title") val title: String,
        @ColumnInfo(name = "release_date") val release_date: String,
        @ColumnInfo(name = "original_language") val original_language: String,
        @ColumnInfo(name = "overview") val overview: String,
        @ColumnInfo(name = "poster_path") val poster_path: String,
        @ColumnInfo(name = "year") val year: Int,
        @field:PrimaryKey(autoGenerate = true) @ColumnInfo(name = "idItem") val idItem: Long = 0
) : Parcelable