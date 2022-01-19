package com.example.letsgetfit.domain.pojo

import androidx.annotation.Keep

@Keep
data class NutritionInfo(
    val title: String,
    val shortDesc: String,
    val backgroundImage: String,
    val date: String,
    val description: String
)