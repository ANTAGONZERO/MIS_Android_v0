package com.example.mis1.viewmodels.project

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mis1.common.ProjectProgressStatus
import com.example.mis1.common.ProjectType
import com.example.mis1.common.Resource
import com.example.mis1.data.remote.project.dto.AddProjectRequest
import com.example.mis1.data.remote.project.dto.Project
import com.example.mis1.data.remote.user.dto.User
import com.example.mis1.repository.ProjectRepository
import com.example.mis1.repository.TrainingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddProjectViewmodel @Inject constructor(
    private val projectRepository: ProjectRepository,
    private val trainingRepository: TrainingRepository
) : ViewModel() {
    val typeOfProject = mutableStateOf<ProjectType?>(null)
    val projectProgressStatus = mutableStateOf<ProjectProgressStatus?>(null)
    val teammateSearch = mutableStateOf("")
    val links = mutableStateOf("")
    val projectTitle = mutableStateOf("")
    val projectDescription = mutableStateOf("")

    val teammates =  mutableStateListOf<User>()
    var teammatesSuggestions by  mutableStateOf<List<User>>(emptyList())
        private set

    var isProjectTypeDDVisible by mutableStateOf(false)
        private set
    var isProgressStatusDDVisible by mutableStateOf(false)
        private set
    var addStatus by mutableStateOf<Resource<Project>>(Resource.Error(""))
        private set
    var isSuggestionVisible by mutableStateOf(false)
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
    private fun showSuggestions(){
        isSuggestionVisible = true
    }
    fun hideSuggestions() {
        isSuggestionVisible = false
    }
    fun addTeammate(user: User){
        teammates.add(user)
    }

    fun setTypeOfProject(value: ProjectType) {
        typeOfProject.value = value
    }

    fun setProjectProgressStatus(value: ProjectProgressStatus) {
        projectProgressStatus.value = value
    }

    fun updateTeammateSearch(value: String) {
        teammateSearch.value = value
        if(teammateSearch.value.isNotEmpty()){
            fetchSuggestions()
        }
    }

    fun deleteTeammate(){
        teammates.removeLastOrNull()
    }

    private fun fetchSuggestions() {
        viewModelScope.launch {
            trainingRepository.searchUser(query = teammateSearch.value).collect{
                it.data?.let { users ->
                    teammatesSuggestions = users
                    if (users.isNotEmpty())
                        showSuggestions()
                }
            }
        }
    }

    fun updateLinks(value: String) {
        links.value = value
    }

    fun updateProjectTitle(value: String) {
        projectTitle.value = value
    }

    fun updateProjectDescription(value: String) {
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
                    student = student,
                    links = links.value,
//                    documents = emptyList(),
                    teammates = teammates.map { user -> user.id }
                )
            ).collect {
                addStatus = it
            }
        }
    }
}