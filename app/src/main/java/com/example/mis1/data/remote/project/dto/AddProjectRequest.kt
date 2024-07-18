package com.example.mis1.data.remote.project.dto


import com.google.gson.annotations.SerializedName

data class AddProjectRequest(
    val description: String,
    @SerializedName("progress_status")
    val progressStatus: Int,
    val student: Int,
    val title: String,
    val type: Int
)