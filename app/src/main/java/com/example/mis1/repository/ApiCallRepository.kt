package com.example.mis1.repository

import com.example.mis1.common.Resource
import kotlinx.coroutines.flow.flow

class ApiCallRepository(tokenRepository: TokenRepository) {
    fun <T> protectedApiCall(errorMessage:String, endpoint:suspend ()->T) = flow {
        try {
            emit(Resource.Loading(null))
            val response = endpoint()
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(message = errorMessage))
        }
    }
}