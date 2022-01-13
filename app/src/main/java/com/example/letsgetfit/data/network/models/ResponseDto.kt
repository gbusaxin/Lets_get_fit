package com.example.letsgetfit.data.network.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ResponseDto(
    @SerializedName("url")
    var response: String
)
