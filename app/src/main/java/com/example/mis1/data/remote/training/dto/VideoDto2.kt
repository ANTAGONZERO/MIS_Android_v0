package com.example.mis1.data.remote.training.dto


import com.google.gson.annotations.SerializedName

data class VideoDto2(
    val college: Int,
    val description: String,
    val id: Int,
    val link: String,
    val title: String,
    @SerializedName("video_length")
    val videoLength: Int?
)