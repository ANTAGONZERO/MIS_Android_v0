package com.example.mis1.data.remote.user.dto


import com.google.gson.annotations.SerializedName

data class RegisterUserRequest(
    val branch: String,
    val currentYear: String,
    val degree: String,
    val email: String,
    val graduationYear: String,
    val hostelAddress: String,
    val name: String,
    val phoneNumber: String
)