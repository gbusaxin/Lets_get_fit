package com.example.letsgetfit.data.network.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




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