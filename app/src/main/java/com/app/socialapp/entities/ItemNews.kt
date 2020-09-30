package com.app.socialapp.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ItemNews(
        @field:SerializedName("title") val title: String,
        @field:SerializedName("message") val message: String) : Serializable