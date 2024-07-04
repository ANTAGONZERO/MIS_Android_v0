package com.example.mis1.repository

import com.example.mis1.common.Resource
import com.example.mis1.data.remote.user.UserApi
import com.example.mis1.data.remote.user.dto.*
import kotlinx.coroutines.flow.flow

class UserRepository (
    private val api: UserApi
) {

    fun login(credentials: UserCredentials) = flow<Resource<LoginUserResponse>> {
        try {
            emit(Resource.Loading(null))
            val response = api.login(credentials)
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(message = "Failed to login"))
        }
    }

    fun register(request: RegisterUserRequest) = flow<Resource<RegisterUserResponse>> {
        try {
            emit(Resource.Loading(null))
            val response = api.register(request)
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(message = "Failed to register"))
        }
    }

    fun userList() = flow<Resource<List<User>>> {
        try {
            emit(Resource.Loading(null))
            val response = api.getUserList()
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(message = "Failed to fetch user list"))
        }
    }

    fun addUserGroup(request: AddUserGroupRequest) = flow<Resource<UserGroup>> {
        try {
            emit(Resource.Loading(null))
            val response = api.addUserGroup(request)
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(message = "Failed to add user group"))
        }
    }

    fun userGroupList() = flow<Resource<List<UserGroup>>> {
        try {
            emit(Resource.Loading(null))
            val response = api.getUserGroupList()
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(message = "Failed to fetch user group list"))
        }
    }

    fun userGroupDetail(id: Int) = flow<Resource<UserGroup>> {
        try {
            emit(Resource.Loading(null))
            val response = api.getUserGroupDetail(id)
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(message = "Failed to fetch user group detail"))
        }
    }
}
