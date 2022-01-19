package com.example.letsgetfit.domain.use_cases

import com.example.letsgetfit.domain.repositories.NutritionRepository

class GetNutritionListUseCase(private val repository: NutritionRepository) {
    operator fun invoke() = repository.getNutritionList()
}