package com.example.letsgetfit.data.network.models

import androidx.annotation.Keep
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Keep
data class NutritionInfoDto(
    @SerializedName("title")
    @Expose
    val title: String? = null,
    @SerializedName("shortDesc")
    @Expose
    val shortDesc: String? = null,
    @SerializedName("backgroundImage")
    @Expose
    val backgroundImage: String? = null,
    @SerializedName("date")
    @Expose
    val date: String? = null,
    @SerializedName("description")
    @Expose
    val description: String? = null
)