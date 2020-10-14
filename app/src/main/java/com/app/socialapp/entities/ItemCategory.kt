package com.app.socialapp.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "item_category")
data class ItemCategory(
        @field:PrimaryKey(autoGenerate = true) @ColumnInfo(name = "idItem") val idItem: Int,
        @ColumnInfo(name = "name") val name: String
) : Parcelable