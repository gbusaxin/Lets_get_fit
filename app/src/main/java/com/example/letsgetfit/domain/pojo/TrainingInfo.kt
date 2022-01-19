package com.example.letsgetfit.domain.pojo

import androidx.annotation.Keep

@Keep
data class TrainingInfo(
    val trainer: String,
    val imageTrainer: String,
    val aboutTrainer: String,
    val training: List<TrainingItem>
)