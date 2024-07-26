package com.example.mis1.data.remote.training

import com.example.mis1.data.remote.training.dto.TutorialDto
import com.example.mis1.data.remote.training.dto.VideoDto2
import com.example.mis1.data.remote.user.dto.User
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TrainingApi {
    @GET("training/search_user/")
    suspend fun searchUser(@Query("q") q: String):List<User>
    @GET("training/tutorials/modules/")
    suspend fun getTutorials(): List<TutorialDto>
    @GET("training/tutorials/videos/{id}/")
    suspend fun getVideo(@Path("id") id:Int):VideoDto2
}