package com.example.letsgetfit.domain.repositories

import androidx.lifecycle.LiveData
import com.example.letsgetfit.domain.pojo.NutritionInfo

interface NutritionRepository {
    fun getNutritionList():LiveData<List<NutritionInfo>>
    suspend fun loadNutritionList()
}