package com.example.mis1.data.remote.user.dto


import com.google.gson.annotations.SerializedName

data class UserGroup(
    @SerializedName("created_at")
    val createdAt: String,
    val description: String?,
    val id: Int,
    @SerializedName("last_updated_at")
    val lastUpdatedAt: String,
    val members: List<Int>,
    val name: String
)