package com.example.mis1.data.remote.user

import com.example.mis1.data.remote.user.dto.LoginUserResponse
import com.example.mis1.data.remote.user.dto.RegisterUserRequest
import com.example.mis1.data.remote.user.dto.RegisterUserResponse
import com.example.mis1.data.remote.user.dto.User
import com.example.mis1.data.remote.user.dto.UserGroup
import retrofit2.http.Body
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserApi {
    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(@FieldMap credentials: Map<String,Any>) : LoginUserResponse

    @POST("auth/student_register")
    suspend fun register(@Body request: RegisterUserRequest) : RegisterUserResponse

    @GET("auth/user")
    suspend fun getUserList():List<User>

    @FormUrlEncoded
    @POST("auth/admin_user_group_list")
    suspend fun addUserGroup(@FieldMap request:Map<String,Any>):UserGroup

    @GET("auth/admin_user_group_list/")
    suspend fun getUserGroupList():List<UserGroup>

    @GET("auth/admin_user_group_list/{id}")
    suspend fun getUserGroupDetail(@Path("id") id: Int):UserGroup

}