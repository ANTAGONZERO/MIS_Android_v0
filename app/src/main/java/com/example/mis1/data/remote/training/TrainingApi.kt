package com.example.mis1.data.remote.training

import com.example.mis1.data.remote.training.dto.Tutorial
import com.example.mis1.data.remote.training.dto.Video
import com.example.mis1.data.remote.user.dto.User
import retrofit2.http.GET
import retrofit2.http.Query

interface TrainingApi {
    @GET("training/search_user/")
    suspend fun searchUser(@Query("q") q: String):List<User>
    @GET("training/tutorials/modules/")
    suspend fun getTutorials(): List<Tutorial>
    @GET("training/tutorials/videos/0/")
    suspend fun getVideos(): List<Video>
}