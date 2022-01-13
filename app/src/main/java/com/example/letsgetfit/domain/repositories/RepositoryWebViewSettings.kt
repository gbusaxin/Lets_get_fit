package com.example.letsgetfit.domain.repositories

import android.webkit.WebSettings
import androidx.lifecycle.LiveData
import com.example.letsgetfit.data.network.models.RequestDto
import com.example.letsgetfit.data.network.models.ResponseDto

interface RepositoryWebViewSettings {
    fun callToServer(request:RequestDto): LiveData<ResponseDto>
    fun getLocale():LiveData<RequestDto>
    fun setWebViewSettings(settings:WebSettings)
}