package com.example.mis1.data.remote.project.dto


import com.google.gson.annotations.SerializedName

data class ProjectDto(
    val college: Int,
    val description: String,
    val documents: Any?,
    val id: Int,
    val links: String?,
    @SerializedName("progress_status")
    val progressStatus: String,
    val student: Int,
    val teammates: List<Int>,
    val title: String,
    val type: String
)