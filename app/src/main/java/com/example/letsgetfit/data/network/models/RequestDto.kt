package com.example.letsgetfit.data.network.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class RequestDto(

    @SerializedName("locale")
    var request: String

)
