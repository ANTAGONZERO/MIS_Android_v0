package com.example.mis1.repository

import com.example.mis1.common.Resource
import com.example.mis1.data.remote.user.UserApi
import com.example.mis1.data.remote.user.dto.*
import kotlinx.coroutines.flow.Flow

class UserRepository(
    private val api: UserApi,
    private val apiCallRepository: ApiCallRepository
) {

    fun login(credentials: UserCredentials): Flow<Resource<LoginUserResponse>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to login") {
            api.login(credentials)
        }

    fun register(request: RegisterUserRequest): Flow<Resource<RegisterUserResponse>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to register") {
            api.register(request)
        }

    fun userList(): Flow<Resource<List<User>>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to fetch user list") {
            api.getUserList()
        }

    fun addUserGroup(request: AddUserGroupRequest): Flow<Resource<UserGroup>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to add user group") {
            api.addUserGroup(request)
        }

    fun userGroupList(): Flow<Resource<List<UserGroup>>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to fetch user group list") {
            api.getUserGroupList()
        }

    fun userGroupDetail(id: Int): Flow<Resource<UserGroup>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to fetch user group detail") {
            api.getUserGroupDetail(id)
        }
}
