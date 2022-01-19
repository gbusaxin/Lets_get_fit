package com.example.letsgetfit.data.database.models

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity(tableName = "table_motivation")
class MotivationInfoDbModel(
    val author: String,
    @PrimaryKey
    val image: String,
    val message: String
)