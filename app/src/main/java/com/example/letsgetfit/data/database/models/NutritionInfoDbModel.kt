package com.example.letsgetfit.data.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "table_nutrition")
data class NutritionInfoDbModel (
    @PrimaryKey
    val title: String,
    val shortDesc: String,
    val backgroundImage: String,
    val date: String,
    val description: String
)