package com.example.letsgetfit.domain.use_cases

import com.example.letsgetfit.domain.repositories.MotivationRepository

class LoadMotivationListUseCase(private val repository: MotivationRepository) {
    suspend operator fun invoke() = repository.loadMotivationList()
}