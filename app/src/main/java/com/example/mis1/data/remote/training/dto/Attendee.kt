package com.example.mis1.data.remote.training.dto


import com.google.gson.annotations.SerializedName

data class Attendee(
    val college: Int,
    val id: Int,
    @SerializedName("is_present")
    val isPresent: Boolean,
    val name: String,
    val user: Int,
    val workshop: Int
)