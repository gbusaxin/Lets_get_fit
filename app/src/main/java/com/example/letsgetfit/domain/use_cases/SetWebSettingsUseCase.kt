package com.example.letsgetfit.domain.use_cases

import android.webkit.WebSettings
import com.example.letsgetfit.domain.repositories.RepositoryWebViewSettings

class SetWebSettingsUseCase(private val repository: RepositoryWebViewSettings) {
    operator fun invoke(settings:WebSettings) = repository.setWebViewSettings(settings)
}