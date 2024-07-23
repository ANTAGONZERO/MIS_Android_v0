package com.example.mis1.repository

import com.example.mis1.data.remote.training.TrainingApi

class TrainingRepository(
    private val api: TrainingApi,
    private val apiCallRepository: ApiCallRepository
) {
    suspend fun searchUser(query: String) = apiCallRepository.protectedApiCall("Unable to fetch users"){
        api.searchUser(query)
    }
}