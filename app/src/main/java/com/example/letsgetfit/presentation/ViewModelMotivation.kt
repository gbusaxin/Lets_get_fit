package com.example.letsgetfit.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.letsgetfit.data.RepositoryMotivationImpl
import com.example.letsgetfit.domain.use_cases.GetMotivationListUseCase
import com.example.letsgetfit.domain.use_cases.LoadMotivationListUseCase
import kotlinx.coroutines.launch

class ViewModelMotivation(application: Application):AndroidViewModel(application) {

    private val repository = RepositoryMotivationImpl(application)

    private val getMotivationListUseCase = GetMotivationListUseCase(repository)
    private val loadMotivationListUseCase = LoadMotivationListUseCase(repository)

    val getMotivationList = getMotivationListUseCase()

    init {
        viewModelScope.launch {
            loadMotivationListUseCase()
        }
    }
}