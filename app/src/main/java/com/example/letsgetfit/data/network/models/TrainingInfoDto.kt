package com.example.letsgetfit.data.network.models

import com.example.letsgetfit.domain.pojo.TrainingItem
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class TrainingInfoDto(
    @SerializedName("trainer")
    @Expose
    val trainer: String? = null,

    @SerializedName("imageTrainer")
    @Expose
    val imageTrainer: String? = null,

    @SerializedName("aboutTrainer")
    @Expose
    val aboutTrainer: String? = null,

    @SerializedName("training")
    @Expose
    val training: List<TrainingItem>? = null
)