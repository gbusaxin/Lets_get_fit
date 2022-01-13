package com.example.letsgetfit.data

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Environment
import android.util.Log
import android.webkit.WebSettings
import androidx.core.os.ConfigurationCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.letsgetfit.data.network.ApiFactory
import com.example.letsgetfit.data.network.models.RequestDto
import com.example.letsgetfit.data.network.models.ResponseDto
import com.example.letsgetfit.domain.repositories.RepositoryWebViewSettings
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class RepositoryWebViewImpl:RepositoryWebViewSettings {

    private var _response:MutableLiveData<ResponseDto>? = null
    private val response:LiveData<ResponseDto> get() = _response!!
    private var _request:MutableLiveData<RequestDto>? = null
    private val request:LiveData<RequestDto> get() = _request!!
    private var _file:MutableLiveData<File>? = null
    private val file:LiveData<File?> get() = _file!!

    private var retrofit = ApiFactory.apiService

    override fun callToServer(request: RequestDto): LiveData<ResponseDto> {
        retrofit.sendLocale(request).enqueue(object : Callback<ResponseDto>{
            override fun onResponse(p0: Call<ResponseDto>, p1: Response<ResponseDto>) {
                _response?.value = p1.body()
            }

            override fun onFailure(p0: Call<ResponseDto>, p1: Throwable) {
                Log.e("APP_ERROR","Can't do call to server in RepositoryWebView",p1)
            }
        })
        return response
    }

    override fun getLocale(): LiveData<RequestDto> {
        val locale = ConfigurationCompat.getLocales(Resources.getSystem().configuration)
        val language = locale[0]
        _request?.value = RequestDto(language.isO3Language)
        return request
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun setWebViewSettings(settings: WebSettings) {
        with(settings){
            domStorageEnabled = true
            useWideViewPort = true
            loadWithOverviewMode = true
            allowFileAccess = true
            allowContentAccess = true
            javaScriptEnabled = true
            displayZoomControls = false
            userAgentString = userAgentString.replace("; wv", "")
        }
    }

}