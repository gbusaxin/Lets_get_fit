package com.example.letsgetfit.data.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "table_motivation")
class MotivationInfoDbModel(
    val author: String,
    @PrimaryKey
    val image: String,
    val message: String
)