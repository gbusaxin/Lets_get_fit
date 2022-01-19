package com.example.letsgetfit.domain.use_cases

import com.example.letsgetfit.domain.repositories.MotivationRepository

class GetMotivationListUseCase(private val repository:MotivationRepository) {
    operator fun invoke() = repository.getMotivationList()
}