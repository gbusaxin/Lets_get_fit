package com.example.letsgetfit.data.network.models

import androidx.annotation.Keep
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName



@Keep
data class MotivationInfoDto (
    @SerializedName("author")
    @Expose
    val author: String? = null,

    @SerializedName("image")
    @Expose
    val image: String? = null,

    @SerializedName("message")
    @Expose
    val message: String? = null
)