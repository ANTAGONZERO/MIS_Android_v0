package com.example.mis1.repository

import com.example.mis1.common.Resource
import com.example.mis1.data.remote.project.ProjectApi
import com.example.mis1.data.remote.project.dto.AddProjectRequest
import com.example.mis1.data.remote.project.dto.Project
import kotlinx.coroutines.flow.Flow

class ProjectRepository(
    private val api: ProjectApi,
    private val apiCallRepository: ApiCallRepository
) {

    fun addProject(request: AddProjectRequest): Flow<Resource<Project>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to add project") {
            api.addProject(request)
        }

    fun listProject(): Flow<Resource<List<Project>>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to fetch project list") {
            api.listProject()
        }
}
