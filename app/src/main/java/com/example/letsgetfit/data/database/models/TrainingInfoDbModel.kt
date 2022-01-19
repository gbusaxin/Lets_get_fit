package com.example.letsgetfit.data.database.models

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.letsgetfit.data.database.converters.TrainingConverter
import com.example.letsgetfit.domain.pojo.TrainingItem

@Keep
@Entity(tableName = "table_training")
@TypeConverters(TrainingConverter::class)
data class TrainingInfoDbModel(
    @PrimaryKey
    val trainer: String,
    val imageTrainer: String,
    val aboutTrainer: String,
    val training: List<TrainingItem>
)