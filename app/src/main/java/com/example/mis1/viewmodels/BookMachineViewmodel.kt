package com.example.mis1.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookMachineViewmodel @Inject constructor(): ViewModel() {
    val date: MutableState<String> = mutableStateOf("")
    val hours: MutableState<String> = mutableStateOf("")
    val startTime: MutableState<String> = mutableStateOf("")
    val endTime: MutableState<String> = mutableStateOf("")
    val projectType: MutableState<String> = mutableStateOf("")
    val projectTitle: MutableState<String> = mutableStateOf("")
    val projectDetails: MutableState<String> = mutableStateOf("")


    fun updateDate(newDate: String) {
        date.value = newDate
    }

    fun updateHours(newHours: String) {
        hours.value = newHours
    }

    fun updateStartTime(newStartTime: String) {
        startTime.value = newStartTime
    }

    fun updateEndTime(newEndTime: String) {
        endTime.value = newEndTime
    }

    fun updateProjectType(newProjectType: String) {
        projectType.value = newProjectType
    }

    fun updateProjectTitle(newProjectTitle: String) {
        projectTitle.value = newProjectTitle
    }

    fun updateProjectDetails(newProjectDetails: String) {
        projectDetails.value = newProjectDetails
    }
}