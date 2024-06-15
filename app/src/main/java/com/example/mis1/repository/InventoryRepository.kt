package com.example.mis1.repository

import com.example.mis1.common.Resource
import com.example.mis1.data.remote.inventory.InventoryApi
import com.example.mis1.data.remote.inventory.dto.AddInventoryRequest
import com.example.mis1.data.remote.inventory.dto.InventoryCategory
import com.example.mis1.data.remote.inventory.dto.InventoryGroup
import com.example.mis1.data.remote.inventory.dto.Inventory
import com.example.mis1.data.remote.inventory.dto.InventoryLocation
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class InventoryRepository (
    private val api: InventoryApi
) {

    fun addInventory(addInventoryRequest: AddInventoryRequest) = flow<Resource<Inventory>> {
        try {
            emit(Resource.Loading(null))
            val response = api.addInventory(addInventoryRequest)
            emit(Resource.Success(response))
        } catch (_: Exception) {
            emit(Resource.Error(message = "Failed to add inventory"))
        }
    }

    fun inventoryList() = flow<Resource<List<Inventory>>> {
        try {
            emit(Resource.Loading(null))
            val response = api.inventoryList()
            emit(Resource.Success(response))
        } catch (_: Exception) {
            emit(Resource.Error(message = "Failed to fetch inventory list"))
        }
    }

    fun inventoryDetail(id: Int) = flow<Resource<Inventory>> {
        try {
            emit(Resource.Loading(null))
            val response = api.inventoryDetail(id)
            emit(Resource.Success(response))
        } catch (_: Exception) {
            emit(Resource.Error(message = "Failed to fetch inventory detail"))
        }
    }

    fun locationList() = flow<Resource<List<InventoryLocation>>> {
        try {
            emit(Resource.Loading(null))
            val response = api.locationList()
            emit(Resource.Success(response))
        } catch (_: Exception) {
            emit(Resource.Error(message = "Failed to fetch location list"))
        }
    }

    fun locationDetail(id: Int) = flow<Resource<InventoryLocation>> {
        try {
            emit(Resource.Loading(null))
            val response = api.locationDetail(id)
            emit(Resource.Success(response))
        } catch (_: Exception) {
            emit(Resource.Error(message = "Failed to fetch location detail"))
        }
    }

    fun groupList() = flow<Resource<List<InventoryGroup>>> {
        try {
            emit(Resource.Loading(null))
            val response = api.groupList()
            emit(Resource.Success(response))
        } catch (_: Exception) {
            emit(Resource.Error(message = "Failed to fetch group list"))
        }
    }

    fun groupDetail(id: Int) = flow<Resource<InventoryGroup>> {
        try {
            emit(Resource.Loading(null))
            val response = api.groupDetail(id)
            emit(Resource.Success(response))
        } catch (_: Exception) {
            emit(Resource.Error(message = "Failed to fetch group detail"))
        }
    }

    fun categoryList() = flow<Resource<List<InventoryCategory>>> {
        try {
            emit(Resource.Loading(null))
            val response = api.categoryList()
            emit(Resource.Success(response))
        } catch (_: Exception) {
            emit(Resource.Error(message = "Failed to fetch category list"))
        }
    }

    fun categoryDetail(id: Int) = flow<Resource<InventoryCategory>> {
        try {
            emit(Resource.Loading(null))
            val response = api.categoryDetail(id)
            emit(Resource.Success(response))
        } catch (_: Exception) {
            emit(Resource.Error(message = "Failed to fetch category detail"))
        }
    }
}
