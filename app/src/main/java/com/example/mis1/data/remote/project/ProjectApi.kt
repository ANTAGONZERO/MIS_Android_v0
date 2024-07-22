package com.example.mis1.data.remote.project

import com.example.mis1.data.remote.project.dto.AddProjectRequest
import com.example.mis1.data.remote.project.dto.Project
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ProjectApi {
    @POST("project/")
    suspend fun addProject(@Body project: AddProjectRequest):Project
    @GET("project/")
    suspend fun listProject():List<Project>

//    @GET("/api/project/{project_id}/")
//    fun getProject(@Path("project_id") projectId: Int)
//
//    @PUT("/api/project/{project_id}/")
//    fun updateProject(@Path("project_id") projectId: Int, @Body project: Project?)
//
//    @PATCH("/api/project/{project_id}/")
//    fun patchProject(@Path("project_id") projectId: Int, @Body project: Project?)
//
//    @DELETE("/api/project/{project_id}/")
//    fun deleteProject(@Path("project_id") projectId: Int)

}