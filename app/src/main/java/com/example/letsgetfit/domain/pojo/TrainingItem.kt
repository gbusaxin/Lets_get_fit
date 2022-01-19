package com.example.letsgetfit.domain.pojo

import androidx.annotation.Keep

@Keep
data class TrainingItem(
    val title: String,
    val exercise: String,
    val image: String
)