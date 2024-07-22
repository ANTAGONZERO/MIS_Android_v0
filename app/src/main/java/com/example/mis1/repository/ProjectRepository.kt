package com.example.mis1.repository

import com.example.mis1.common.Resource
import com.example.mis1.data.remote.project.ProjectApi
import com.example.mis1.data.remote.project.dto.AddProjectRequest
import kotlinx.coroutines.flow.flow

class ProjectRepository(private val api: ProjectApi) {
    suspend fun addProject(request: AddProjectRequest) = flow {
        try {
            emit(Resource.Loading())
            val response = api.addProject(request)
            emit(Resource.Success(response))
        }catch (e:Exception){
            emit(Resource.Error(message = e.message))
        }
    }

    suspend fun listProject() = flow {
        try {
            emit(Resource.Loading())
            val list  = api.listProject()
            emit(Resource.Success(list))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message))
        }
    }
}