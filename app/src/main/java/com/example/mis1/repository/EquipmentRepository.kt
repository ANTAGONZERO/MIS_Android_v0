package com.example.mis1.repository

import com.example.mis1.common.Resource
import com.example.mis1.data.remote.equipment.EquipmentApi
import com.example.mis1.data.remote.equipment.dto.Equipment
import kotlinx.coroutines.flow.Flow

class EquipmentRepository(
    private val api: EquipmentApi,
    private val apiCallRepository: ApiCallRepository
) {

    fun equipmentList(): Flow<Resource<List<Equipment>>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to fetch equipment list") {
            api.getEquipmentList()
        }

    fun equipmentDetail(id: Int): Flow<Resource<Equipment>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to fetch equipment detail") {
            api.getEquipmentDetail(id)
        }
}
