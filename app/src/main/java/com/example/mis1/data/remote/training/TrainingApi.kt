package com.example.mis1.data.remote.training

import com.example.mis1.data.remote.training.dto.Attendee
import com.example.mis1.data.remote.training.dto.TutorialDto
import com.example.mis1.data.remote.training.dto.VideoDto2
import com.example.mis1.data.remote.training.dto.Workshop
import com.example.mis1.data.remote.user.dto.User
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface TrainingApi {
    @GET("training/search_user/")
    suspend fun searchUser(@Query("q") q: String):List<User>
    @GET("training/tutorials/modules/")
    suspend fun tutorialList(): List<TutorialDto>
    @GET("training/tutorials/videos/{id}/")
    suspend fun videoDetail(@Path("id") id:Int):VideoDto2
    @GET("training/workshops/")
    suspend fun workshopList(): List<Workshop>
    @POST("training/workshops/{id}/register/")
    suspend fun registerForWorkshop(@Path("id") id:Int):Attendee
}