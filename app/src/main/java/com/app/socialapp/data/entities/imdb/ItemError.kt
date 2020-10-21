package com.app.socialapp.data.entities.imdb

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ItemError(
        @field:SerializedName("Response") val response: String,
        @field:SerializedName("Error") val error: String
) : Serializable