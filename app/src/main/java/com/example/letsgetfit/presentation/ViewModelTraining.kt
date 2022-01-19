package com.example.letsgetfit.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.letsgetfit.data.RepositoryTrainingImpl
import com.example.letsgetfit.domain.pojo.TrainingInfo
import com.example.letsgetfit.domain.use_cases.GetTrainingListUseCase
import com.example.letsgetfit.domain.use_cases.LoadTrainingListUseCase
import kotlinx.coroutines.launch

class ViewModelTraining(application: Application) : AndroidViewModel(application) {

    private val repositoryImpl = RepositoryTrainingImpl(application)

    private val getTrainingListUseCase = GetTrainingListUseCase(repositoryImpl)
    private val loadTrainingListUseCase = LoadTrainingListUseCase(repositoryImpl)

    private val _selectedTraining = MutableLiveData<TrainingInfo>()
    val selectedTraining: LiveData<TrainingInfo>
        get() = _selectedTraining

    val trainingList = getTrainingListUseCase()

    fun selectTraining(training:TrainingInfo){
        _selectedTraining.value = training
    }

    init {
        viewModelScope.launch {
            loadTrainingListUseCase()
        }
    }
}