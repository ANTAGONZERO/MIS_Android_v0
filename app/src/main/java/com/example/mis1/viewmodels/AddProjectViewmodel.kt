package com.example.mis1.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddProjectViewmodel @Inject constructor(): ViewModel(){
    val studentID = mutableStateOf("")
    val typeOfProject = mutableStateOf("")
    val projectProgressStatus = mutableStateOf("")
    val teammates = mutableStateOf("")
    val linksOrDocuments = mutableStateOf("")
    val projectTitle = mutableStateOf("")
    val projectDescription = mutableStateOf("")

    fun setStudentID(value: String) {
        studentID.value = value
    }

    fun setTypeOfProject(value: String) {
        typeOfProject.value = value
    }

    fun setProjectProgressStatus(value: String) {
        projectProgressStatus.value = value
    }

    fun setTeammates(value: String) {
        teammates.value = value
    }

    fun setLinksOrDocuments(value: String) {
        linksOrDocuments.value = value
    }

    fun setProjectTitle(value: String) {
        projectTitle.value = value
    }

    fun setProjectDescription(value: String) {
        projectDescription.value = value
    }
}