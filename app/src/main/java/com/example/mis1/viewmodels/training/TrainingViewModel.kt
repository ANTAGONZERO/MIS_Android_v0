package com.example.mis1.viewmodels.training

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mis1.model.Tutorial
import com.example.mis1.repository.TrainingRepository
import com.example.mis1.ui.routes.TrainingTabs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrainingViewModel @Inject constructor(
    private val trainingRepository: TrainingRepository
):ViewModel() {
    var visibleTab by mutableStateOf(TrainingTabs.TUTORIALS)
        private set
    var tutorials  = mutableStateListOf<Tutorial>()
        private set

    fun goto(tab: TrainingTabs) {
        visibleTab = tab
    }

    init {
        fetchTutorials()
    }

    private fun fetchTutorials(){
        viewModelScope.launch {
            trainingRepository.tutorialList().collect {
                it.data?.let { tutorialList ->
                    tutorials.clear()
                    tutorials.addAll(tutorialList)
                } ?: run {
                    tutorials.clear()
                }
            }
        }

    }
}