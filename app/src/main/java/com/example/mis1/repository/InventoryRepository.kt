package com.example.mis1.repository

import com.example.mis1.common.Resource
import com.example.mis1.data.remote.inventory.InventoryApi
import com.example.mis1.data.remote.inventory.dto.AddInventoryRequest
import com.example.mis1.data.remote.inventory.dto.Inventory
import com.example.mis1.data.remote.inventory.dto.InventoryCategory
import com.example.mis1.data.remote.inventory.dto.InventoryGroup
import com.example.mis1.data.remote.inventory.dto.InventoryLocation
import com.example.mis1.data.remote.inventory.dto.InventoryPurchaseDto
import com.example.mis1.data.remote.inventory.dto.IssueInventoryRequest
import com.example.mis1.data.remote.inventory.dto.IssuedInventoryDto
import com.example.mis1.data.remote.inventory.dto.PurchaseInventoryRequest
import com.example.mis1.model.InventoryPurchase
import com.example.mis1.model.IssuedInventory
import kotlinx.coroutines.flow.Flow

class InventoryRepository(
    private val api: InventoryApi,
    private val apiCallRepository: ApiCallRepository
) {

    fun addInventory(addInventoryRequest: AddInventoryRequest): Flow<Resource<Inventory>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to add inventory") {
            api.addInventory(addInventoryRequest)
        }

    fun inventoryList(): Flow<Resource<List<Inventory>>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to fetch inventory list") {
            api.inventoryList()
        }

    fun inventoryDetail(id: Int): Flow<Resource<Inventory>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to fetch inventory detail") {
            api.inventoryDetail(id)
        }

    fun locationList(): Flow<Resource<List<InventoryLocation>>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to fetch location list") {
            api.locationList()
        }

    fun locationDetail(id: Int): Flow<Resource<InventoryLocation>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to fetch location detail") {
            api.locationDetail(id)
        }

    fun groupList(): Flow<Resource<List<InventoryGroup>>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to fetch group list") {
            api.groupList()
        }

    fun groupDetail(id: Int): Flow<Resource<InventoryGroup>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to fetch group detail") {
            api.groupDetail(id)
        }

    fun categoryList(): Flow<Resource<List<InventoryCategory>>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to fetch category list") {
            api.categoryList()
        }

    fun categoryDetail(id: Int): Flow<Resource<InventoryCategory>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to fetch category detail") {
            api.categoryDetail(id)
        }

    fun issuedInventoryList(): Flow<Resource<List<IssuedInventory>>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to fetch issued inventory list") {
            val response = api.issuedInventoryList()
            val result = mutableListOf<IssuedInventory>()
            response.forEach {
                try {
                    result.add(resolveIssuedInventory(it))
                    emit(Resource.Success(result.toList()))
                } catch (_: Exception) {

                }
            }
            result.toList()
        }

    fun purchasedInventoryList(): Flow<Resource<List<InventoryPurchase>>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to fetch purchased inventory list") {
            val response = api.purchasedInventoryList()
            val result = mutableListOf<InventoryPurchase>()
            response.forEach {
                try {
                    result.add(resolveInventoryPurchase(it))
                    emit(Resource.Success(result.toList()))
                } catch (_: Exception) {

                }
            }
            result.toList()
        }

    private suspend fun resolveIssuedInventory(issuedInventoryDto: IssuedInventoryDto): IssuedInventory {
        val inventory = api.inventoryDetail(id = issuedInventoryDto.inventory)
        return IssuedInventory(
            createdAt = issuedInventoryDto.createdAt,
            id = issuedInventoryDto.id,
            inventory = inventory,
            issuedBy = issuedInventoryDto.issuedBy,
            issuedFrom = issuedInventoryDto.issuedFrom,
            issuedTill = issuedInventoryDto.issuedTill,
            lastUpdatedAt = issuedInventoryDto.lastUpdatedAt,
            pickup = issuedInventoryDto.pickup,
            pickupOn = issuedInventoryDto.pickupOn,
            quantity = issuedInventoryDto.quantity,
            returnDescription = issuedInventoryDto.returnDescription,
            returned = issuedInventoryDto.returned,
            returnedOn = issuedInventoryDto.returnedOn
        )
    }

    private suspend fun resolveInventoryPurchase(inventoryPurchaseDto: InventoryPurchaseDto): InventoryPurchase {
        val inventory = api.inventoryDetail(id = inventoryPurchaseDto.inventory)
        return InventoryPurchase(
            createdAt = inventoryPurchaseDto.createdAt,
            id = inventoryPurchaseDto.id,
            inventory = inventory,
            lastUpdatedAt = inventoryPurchaseDto.lastUpdatedAt,
            paymentMethod = inventoryPurchaseDto.paymentMethod,
            pickup = inventoryPurchaseDto.pickup,
            purchaseAmount = inventoryPurchaseDto.purchaseAmount,
            purchaseDatetime = inventoryPurchaseDto.purchaseDatetime,
            purchasedBy = inventoryPurchaseDto.purchasedBy,
            quantity = inventoryPurchaseDto.quantity,
            returnDescription = inventoryPurchaseDto.returnDescription,
            returnReason = inventoryPurchaseDto.returnReason,
            returned = inventoryPurchaseDto.returned,
            returnedOn = inventoryPurchaseDto.returnedOn
        )
    }

    fun issueInventory(request: IssueInventoryRequest): Flow<Resource<IssuedInventoryDto>> =
        apiCallRepository.protectedApiCall(errorMessage = "Couldn't issue inventory") {
            api.issueInventory(request)
        }

    fun purchaseInventory(request: PurchaseInventoryRequest): Flow<Resource<InventoryPurchaseDto>> =
        apiCallRepository.protectedApiCall(errorMessage = "Couldn't purchase inventory") {
            api.purchaseInventory(request)
        }
}
