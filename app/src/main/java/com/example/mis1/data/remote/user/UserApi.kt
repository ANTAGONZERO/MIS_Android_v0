package com.example.mis1.data.remote.user

import com.example.mis1.data.remote.user.dto.AddUserGroupRequest
import com.example.mis1.data.remote.user.dto.LoginUserResponse
import com.example.mis1.data.remote.user.dto.RegisterUserRequest
import com.example.mis1.data.remote.user.dto.RegisterUserResponse
import com.example.mis1.data.remote.user.dto.User
import com.example.mis1.data.remote.user.dto.UserCredentials
import com.example.mis1.data.remote.user.dto.UserGroup
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserApi {
    @POST("auth/login/")
    suspend fun login(@Body credentials: UserCredentials) : LoginUserResponse

    @POST("auth/student_register/")
    suspend fun register(@Body request: RegisterUserRequest) : RegisterUserResponse

    @GET("auth/user")
    suspend fun getUserList():List<User>

    @POST("auth/admin_user_group_list/")
    suspend fun addUserGroup(@Body request:AddUserGroupRequest):UserGroup

    @GET("auth/admin_user_group_list/")
    suspend fun getUserGroupList():List<UserGroup>

    @GET("auth/admin_user_group_list/{id}")
    suspend fun getUserGroupDetail(@Path("id") id: Int):UserGroup

}