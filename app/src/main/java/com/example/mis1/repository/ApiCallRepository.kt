package com.example.mis1.repository
import com.example.mis1.common.Resource
import com.example.mis1.data.remote.user.UserApi
import com.example.mis1.data.remote.user.dto.NewAccessTokenRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import  retrofit2.HttpException

class ApiCallRepository(private val api: UserApi, private val tokenRepository: TokenRepository) {
    fun <T> protectedApiCall(errorMessage: String, endpoint: suspend () -> T): Flow<Resource<T>> = flow {
        try {
            emit(Resource.Loading(null))
            val response = endpoint()
            emit(Resource.Success(response))
        } catch (e: HttpException) {
            if (e.code() == 401) {
                handleUnauthorized(endpoint, errorMessage)
            } else {
                emit(Resource.Error(message = errorMessage))
            }
        } catch (e: Exception) {
            emit(Resource.Error(message = errorMessage))
        }
    }

    private suspend fun <T> FlowCollector<Resource<T>>.handleUnauthorized(endpoint: suspend () -> T, errorMessage: String) {
        val accessToken = getAccessToken()
        tokenRepository.token = accessToken
        try {
            val response = endpoint()
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(message = errorMessage))
        }
    }

    private suspend fun getAccessToken(): String? {
        return try {
            tokenRepository.refresh?.let {
                api.getNewAccessToken(NewAccessTokenRequest(refresh = it)).access
            }
        } catch (e: Exception) {
            null
        }
    }
}