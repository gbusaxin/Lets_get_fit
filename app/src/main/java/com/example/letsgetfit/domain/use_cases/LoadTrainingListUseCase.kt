package com.example.letsgetfit.domain.use_cases

import com.example.letsgetfit.domain.repositories.TrainingRepository

class LoadTrainingListUseCase(private val repository: TrainingRepository) {
    suspend operator fun invoke() = repository.loadTrainingList()
}