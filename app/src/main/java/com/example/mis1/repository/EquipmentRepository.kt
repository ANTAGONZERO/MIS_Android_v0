package com.example.mis1.repository

import com.example.mis1.common.Resource
import com.example.mis1.data.remote.equipment.EquipmentApi
import com.example.mis1.data.remote.equipment.dto.Equipment
import kotlinx.coroutines.flow.flow

class EquipmentRepository (
    private val api: EquipmentApi
) {

    fun equipmentList() = flow<Resource<List<Equipment>>> {
        try {
            emit(Resource.Loading(null))
            val response = api.getEquipmentList()
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(message = "Failed to fetch equipment list"))
        }
    }

    fun equipmentDetail(id: Int) = flow<Resource<Equipment>> {
        try {
            emit(Resource.Loading(null))
            val response = api.getEquipmentDetail(id)
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(message = "Failed to fetch equipment detail"))
        }
    }
}
