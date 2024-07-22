package com.example.mis1.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mis1.common.ProjectProgressStatus
import com.example.mis1.common.ProjectType
import com.example.mis1.common.Resource
import com.example.mis1.data.remote.project.dto.AddProjectRequest
import com.example.mis1.data.remote.project.dto.Project
import com.example.mis1.repository.ProjectRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddProjectViewmodel @Inject constructor(
    private val projectRepository: ProjectRepository
) : ViewModel() {
    val studentID = mutableStateOf("")
    val typeOfProject = mutableStateOf<ProjectType?>(null)
    val projectProgressStatus = mutableStateOf<ProjectProgressStatus?>(null)
    val teammates = mutableStateOf("")
    val linksOrDocuments = mutableStateOf("")
    val projectTitle = mutableStateOf("")
    val projectDescription = mutableStateOf("")

    var isProjectTypeDDVisible by mutableStateOf(false)
        private set
    var isProgressStatusDDVisible by mutableStateOf(false)
        private set
    var addStatus by mutableStateOf<Resource<Project>>(Resource.Error(""))
        private set

    fun showProjectTypeDD() {
        isProjectTypeDDVisible = true
    }

    fun hideProjectTypeDD() {
        isProjectTypeDDVisible = false
    }

    fun showProgressStatusDD() {
        isProgressStatusDDVisible = true
    }

    fun hideProgressStatusDD() {
        isProgressStatusDDVisible = false
    }

    fun setStudentID(value: String) {
        studentID.value = value
    }

    fun setTypeOfProject(value: ProjectType) {
        typeOfProject.value = value
    }

    fun setProjectProgressStatus(value: ProjectProgressStatus) {
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

    fun addProject(student: Int) {
        if (typeOfProject.value == null || projectProgressStatus.value == null)
            return
        viewModelScope.launch {
            projectRepository.addProject(
                AddProjectRequest(
                    type = typeOfProject.value!!.id.toInt(),
                    progressStatus = projectProgressStatus.value!!.id.toInt(),
                    title = projectTitle.value,
                    description = projectDescription.value,
                    student = student
                )
            ).collect {
                addStatus = it
            }
        }
    }
}