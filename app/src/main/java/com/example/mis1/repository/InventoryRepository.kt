package com.example.mis1.repository

import com.example.mis1.common.Resource
import com.example.mis1.data.remote.inventory.InventoryApi
import com.example.mis1.data.remote.inventory.dto.AddInventoryRequest
import com.example.mis1.data.remote.inventory.dto.Inventory
import com.example.mis1.data.remote.inventory.dto.InventoryCategory
import com.example.mis1.data.remote.inventory.dto.InventoryGroup
import com.example.mis1.data.remote.inventory.dto.InventoryLocation
import com.example.mis1.data.remote.inventory.dto.InventoryPurchase
import com.example.mis1.data.remote.inventory.dto.IssueInventoryRequest
import com.example.mis1.data.remote.inventory.dto.IssuedInventory
import com.example.mis1.data.remote.inventory.dto.PurchaseInventoryRequest
import com.example.mis1.data.remote.inventory.dto.ResolvedInventoryPurchase
import com.example.mis1.data.remote.inventory.dto.ResolvedIssuedInventory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class InventoryRepository(
    private val api: InventoryApi,
    private val apiCallRepository: ApiCallRepository
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

    fun issuedInventoryList() = flow<Resource<List<ResolvedIssuedInventory>>> {
        try {
            emit(Resource.Loading(null))
            val response = api.issuedInventoryList()
            val result = mutableListOf<ResolvedIssuedInventory>()
            response.forEach{
                try {
                    result.add(resolveIssuedInventory(it))
                }catch (_:Exception){

                }
            }
            emit(Resource.Success(result.toList()))
        } catch (e: Exception) {
            emit(Resource.Error(message = "Failed to fetch issued inventory list"))
        }
    }

    fun purchasedInventoryList() = flow<Resource<List<ResolvedInventoryPurchase>>> {
        try {
            emit(Resource.Loading(null))
            val response = api.purchasedInventoryList()
            val result = mutableListOf<ResolvedInventoryPurchase>()
            response.forEach {
                try {
                    result.add(resolveInventoryPurchase(it))
                } catch (_: Exception) {

                }
            }
            emit(Resource.Success(result.toList()))
        } catch (e: Exception) {
            emit(Resource.Error(message = "Failed to fetch purchased inventory list"))
        }
    }

    private suspend fun resolveIssuedInventory(issuedInventory: IssuedInventory): ResolvedIssuedInventory {
        val inventory = api.inventoryDetail(id = issuedInventory.inventory)
        return ResolvedIssuedInventory(
            createdAt = issuedInventory.createdAt,
            id = issuedInventory.id,
            inventory = inventory,
            issuedBy = issuedInventory.issuedBy,
            issuedFrom = issuedInventory.issuedFrom,
            issuedTill = issuedInventory.issuedTill,
            lastUpdatedAt = issuedInventory.lastUpdatedAt,
            pickup = issuedInventory.pickup,
            pickupOn = issuedInventory.pickupOn,
            quantity = issuedInventory.quantity,
            returnDescription = issuedInventory.returnDescription,
            returned = issuedInventory.returned,
            returnedOn = issuedInventory.returnedOn
        )
    }

    private suspend fun resolveInventoryPurchase(inventoryPurchase: InventoryPurchase): ResolvedInventoryPurchase {
        val inventory = api.inventoryDetail(id = inventoryPurchase.inventory)
        return ResolvedInventoryPurchase(
            createdAt = inventoryPurchase.createdAt,
            id = inventoryPurchase.id,
            inventory = inventory,
            lastUpdatedAt = inventoryPurchase.lastUpdatedAt,
            paymentMethod = inventoryPurchase.paymentMethod,
            pickup = inventoryPurchase.pickup,
            purchaseAmount = inventoryPurchase.purchaseAmount,
            purchaseDatetime = inventoryPurchase.purchaseDatetime,
            purchasedBy = inventoryPurchase.purchasedBy,
            quantity = inventoryPurchase.quantity,
            returnDescription = inventoryPurchase.returnDescription,
            returnReason = inventoryPurchase.returnReason,
            returned = inventoryPurchase.returned,
            returnedOn = inventoryPurchase.returnedOn
        )
    }

    fun issueInventory(request: IssueInventoryRequest):Flow<Resource<IssuedInventory>> = apiCallRepository.protectedApiCall("Couldn't issue inventory"){
        api.issueInventory(request)
    }

    fun purchaseInventory(request: PurchaseInventoryRequest):Flow<Resource<InventoryPurchase>> = apiCallRepository.protectedApiCall("Couldn't purchase inventory"){
        api.purchaseInventory(request)
    }
}
