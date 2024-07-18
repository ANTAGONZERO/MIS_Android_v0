package com.example.mis1.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mis1.model.Date
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PurchaseInventoryViewmodel @Inject constructor() : ViewModel() {

    val studentID = mutableStateOf("")
    val typeOfProject = mutableStateOf("")
    val projectProgressStatus = mutableStateOf("")
    val teammates = mutableStateOf("")
    val linksOrDocuments = mutableStateOf("")
    val projectTitle = mutableStateOf("")
    val projectDescription = mutableStateOf("")
    val startDate = mutableStateOf<Date?>(null)
    val endDate = mutableStateOf<Date?>(null)
    val quantity = mutableStateOf("")
    val unit = mutableStateOf("")

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

    fun setStartDate(value: Date) {
        startDate.value = value
    }

    fun setEndDate(value: Date) {
        endDate.value = value
    }

    fun setQuantity(value: String) {
        quantity.value = value
    }

    fun setUnit(value: String) {
        unit.value = value
    }
}