package com.example.letsgetfit.domain.repositories

import androidx.lifecycle.LiveData
import com.example.letsgetfit.domain.pojo.MotivationInfo

interface MotivationRepository {
    fun getMotivationList():LiveData<List<MotivationInfo>>
    suspend fun loadMotivationList()
}