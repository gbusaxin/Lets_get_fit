package com.example.letsgetfit.domain.use_cases

import com.example.letsgetfit.domain.repositories.RepositoryWebViewSettings

class GetLocaleUseCase(private val repository: RepositoryWebViewSettings) {
    operator fun invoke() = repository.getLocale()
}