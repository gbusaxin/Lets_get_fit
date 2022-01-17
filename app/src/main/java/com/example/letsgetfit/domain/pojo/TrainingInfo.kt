package com.example.letsgetfit.domain.pojo


data class TrainingInfo(
    val trainer: String,
    val imageTrainer: String,
    val aboutTrainer: String,
    val training: List<TrainingItem>
)