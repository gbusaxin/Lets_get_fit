package com.example.letsgetfit.data.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.letsgetfit.domain.pojo.TrainingItem

@Entity(tableName = "table_training")
data class TrainingInfoDbModel(
    @PrimaryKey
    val trainer: String,
    val imageTrainer: String,
    val aboutTrainer: String,
    val training: List<TrainingItem>
)