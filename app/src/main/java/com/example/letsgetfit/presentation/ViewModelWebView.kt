package com.example.letsgetfit.presentation

import android.webkit.WebSettings
import androidx.lifecycle.ViewModel
import com.example.letsgetfit.data.RepositoryWebViewImpl
import com.example.letsgetfit.data.network.models.RequestDto
import com.example.letsgetfit.domain.use_cases.CallToServerUseCase
import com.example.letsgetfit.domain.use_cases.GetLocaleUseCase
import com.example.letsgetfit.domain.use_cases.SetWebSettingsUseCase

class ViewModelWebView() : ViewModel() {

    private val repository = RepositoryWebViewImpl()

    private val callToServerUseCase = CallToServerUseCase(repository)
    private val getLocaleUseCase = GetLocaleUseCase(repository)
    private val setWebSettingsUseCase = SetWebSettingsUseCase(repository)

    val getLocale = getLocaleUseCase()

    fun setWebViewSettings(settings: WebSettings) = setWebSettingsUseCase(settings)

    fun callToServer(request: RequestDto) = callToServerUseCase(request)

}