package com.example.mis1.data.remote.user.dto


import com.google.gson.annotations.SerializedName

data class RegisterUserResponse(
    @SerializedName("user_request")
    val userDetails : User2
)