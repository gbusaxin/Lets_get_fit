package com.example.letsgetfit.domain.use_cases

import com.example.letsgetfit.data.network.models.RequestDto
import com.example.letsgetfit.domain.repositories.RepositoryWebViewSettings

class CallToServerUseCase(private val repository:RepositoryWebViewSettings) {
    operator fun invoke(request: RequestDto) = repository.callToServer(request)
}