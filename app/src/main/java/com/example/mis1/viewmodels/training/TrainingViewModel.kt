package com.example.mis1.viewmodels.training

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.mis1.data.remote.training.dto.Tutorial
import com.example.mis1.ui.routes.TrainingTabs
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TrainingViewModel @Inject constructor():ViewModel() {
    var visibleTab by mutableStateOf(TrainingTabs.TUTORIALS)
        private set
    var tutorials  = mutableStateListOf<Tutorial>()
        private set

    fun goto(tab: TrainingTabs) {
        visibleTab = tab
    }

}