package com.example.letsgetfit.domain.use_cases

import com.example.letsgetfit.domain.repositories.NutritionRepository

class LoadNutritionListUseCase(private val repository: NutritionRepository) {
    suspend operator fun invoke() = repository.loadNutritionList()
}