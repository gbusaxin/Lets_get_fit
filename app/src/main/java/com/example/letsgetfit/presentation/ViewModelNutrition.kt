package com.example.letsgetfit.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.letsgetfit.data.RepositoryNutritionImpl
import com.example.letsgetfit.domain.use_cases.GetNutritionListUseCase
import com.example.letsgetfit.domain.use_cases.LoadNutritionListUseCase
import kotlinx.coroutines.launch

class ViewModelNutrition(application: Application) : AndroidViewModel(application) {

    private val repository = RepositoryNutritionImpl(application)

    private val getNutritionListUseCase = GetNutritionListUseCase(repository)
    private val loadNutritionListUseCase = LoadNutritionListUseCase(repository)

    val getNutritionList = getNutritionListUseCase()

    init {
        viewModelScope.launch {
            loadNutritionListUseCase()
        }
    }
}