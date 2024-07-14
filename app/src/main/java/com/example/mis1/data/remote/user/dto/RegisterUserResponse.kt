package com.example.mis1.data.remote.user.dto


import com.google.gson.annotations.SerializedName

data class RegisterUserResponse(
    @SerializedName("college_name")
    val collegeName: String,
    val refresh: String,
    @SerializedName("task_id")
    val taskId: String,
    val token: String,
    val user: String
)