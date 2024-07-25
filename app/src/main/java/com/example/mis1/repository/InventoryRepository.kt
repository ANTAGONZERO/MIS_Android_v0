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

    fun issuedInventoryList(): Flow<Resource<List<ResolvedIssuedInventory>>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to fetch issued inventory list") {
            val response = api.issuedInventoryList()
            val result = mutableListOf<ResolvedIssuedInventory>()
            response.forEach {
                try {
                    result.add(resolveIssuedInventory(it))
                } catch (_: Exception) {
                    // Handle the exception if necessary
                }
            }
            result.toList()
        }

    fun purchasedInventoryList(): Flow<Resource<List<ResolvedInventoryPurchase>>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to fetch purchased inventory list") {
            val response = api.purchasedInventoryList()
            val result = mutableListOf<ResolvedInventoryPurchase>()
            response.forEach {
                try {
                    result.add(resolveInventoryPurchase(it))
                } catch (_: Exception) {
                    // Handle the exception if necessary
                }
            }
            result.toList()
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

    fun issueInventory(request: IssueInventoryRequest): Flow<Resource<IssuedInventory>> =
        apiCallRepository.protectedApiCall(errorMessage = "Couldn't issue inventory") {
            api.issueInventory(request)
        }

    fun purchaseInventory(request: PurchaseInventoryRequest): Flow<Resource<InventoryPurchase>> =
        apiCallRepository.protectedApiCall(errorMessage = "Couldn't purchase inventory") {
            api.purchaseInventory(request)
        }
}
