package com.example.letsgetfit.data.network

import com.example.letsgetfit.data.network.models.RequestDto
import com.example.letsgetfit.data.network.models.ResponseDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

@POST("splash.php")
fun sendLocale(@Body locale:RequestDto):Call<ResponseDto>

}