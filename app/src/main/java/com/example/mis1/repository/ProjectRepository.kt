package com.example.mis1.repository

import com.example.mis1.common.ProjectProgressStatus
import com.example.mis1.common.ProjectType
import com.example.mis1.common.Resource
import com.example.mis1.data.remote.project.ProjectApi
import com.example.mis1.data.remote.project.dto.AddProjectRequest
import com.example.mis1.data.remote.project.dto.ProjectDto
import com.example.mis1.model.Project
import kotlinx.coroutines.flow.Flow

class ProjectRepository(
    private val api: ProjectApi,
    private val apiCallRepository: ApiCallRepository
) {

    fun addProject(request: AddProjectRequest): Flow<Resource<ProjectDto>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to add project") {
            api.addProject(request)
        }

    fun listProject(): Flow<Resource<List<Project>>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to fetch project list") {
            val projectDTOs = api.listProject()
            projectDTOs.map{ it.toProject()}
        }
    private fun ProjectDto.toProject() : Project{
        return Project(
            college = this.college,
            description = this.description,
            documents = this.documents,
            id = this.id,
            links = this.links,
            progressStatus = ProjectProgressStatus.fromId(this.progressStatus),
            student = this.student,
            teammates = this.teammates,
            title = this.title,
            type = ProjectType.fromId(this.type)
        )
    }
}
