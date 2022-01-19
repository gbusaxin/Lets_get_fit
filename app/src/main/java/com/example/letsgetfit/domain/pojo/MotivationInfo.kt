package com.example.letsgetfit.domain.pojo

import androidx.annotation.Keep

@Keep
data class MotivationInfo(
    val author: String,
    val image: String,
    val message: String
)