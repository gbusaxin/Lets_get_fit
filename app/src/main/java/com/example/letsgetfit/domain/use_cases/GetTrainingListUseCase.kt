package com.example.letsgetfit.domain.use_cases

import com.example.letsgetfit.domain.repositories.TrainingRepository

class GetTrainingListUseCase(private val repository: TrainingRepository) {
    operator fun invoke() = repository.getTrainingList()
}