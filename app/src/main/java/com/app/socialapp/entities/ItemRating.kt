package com.app.socialapp.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ItemRating(
        @field:SerializedName("Source") val source: String,
        @field:SerializedName("Value") val value: String
) : Serializable