package com.example.mis1.model

data class Project(
    val college: Int,
    val description: String,
    val documents: Any?,
    val id: Int,
    val links: String?,
    val progressStatus: ProjectProgressStatus?,
    val student: Int,
    val teammates: List<Int>,
    val title: String,
    val type: ProjectType?
)