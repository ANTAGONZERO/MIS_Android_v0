package com.example.mis1.data.remote.user.dto


data class LoginUserResponse(
    val access: String,
    val refresh: String,
    val user: User
)