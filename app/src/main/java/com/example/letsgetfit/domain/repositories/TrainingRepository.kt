package com.example.letsgetfit.domain.repositories

import androidx.lifecycle.LiveData
import com.example.letsgetfit.domain.pojo.TrainingInfo

interface TrainingRepository {
    fun getTrainingList():LiveData<List<TrainingInfo>>
    suspend fun loadTrainingList()
}