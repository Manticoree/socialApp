package com.app.socialapp.data.entities.db

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "item_category")
data class ItemCategory(
        @ColumnInfo(name = "name") val name: String,
        @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "idItem") val idItem: Long = 0
) : Parcelable