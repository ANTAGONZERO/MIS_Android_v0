package com.example.mis1.repository
import com.example.mis1.common.Resource
import com.example.mis1.data.remote.user.UserApi
import com.example.mis1.data.remote.user.dto.NewAccessTokenRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import  retrofit2.HttpException

class ApiCallRepository(private val api: UserApi, private val tokenRepository: TokenRepository) {
    /**
     * Executes a protected API call that handles loading, success, and error states.
     * If the API call returns a 401 Unauthorized error, it attempts to refresh the access token
     * and retries the request.
     *
     * @param errorMessage The error message to emit if the request fails.
     * @param endpoint The suspend function that performs the API call. This function can
     * emit intermediate values between a success and a failure using the FlowCollector.
     * @return A Flow that emits Resource<T> indicating the loading, success, or error state.
     *
     */
    fun <T> protectedApiCall(errorMessage: String, endpoint: suspend FlowCollector<Resource<T>>.() -> T): Flow<Resource<T>> = flow {
        try {
            emit(Resource.Loading(null))
            val response = this.endpoint()
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

    private suspend fun <T> FlowCollector<Resource<T>>.handleUnauthorized(endpoint: suspend FlowCollector<Resource<T>>.() -> T, errorMessage: String) {
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