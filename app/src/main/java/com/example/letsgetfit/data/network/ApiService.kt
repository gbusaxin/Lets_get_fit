package com.example.letsgetfit.data.network

import com.example.letsgetfit.data.network.models.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("splash.php")
    fun sendLocale(@Body locale: RequestDto): Call<ResponseDto>

    @GET("let_training.json")
    suspend fun loadTrainingList(): List<TrainingInfoDto>

    @GET("let_nutrition.json")
    suspend fun loadNutritionList():List<NutritionInfoDto>

    @GET("let_motivation.json")
    suspend fun loadMotivationList():List<MotivationInfoDto>

}