package com.example.mis1.data.remote.inventory

import com.example.mis1.data.remote.inventory.dto.AddInventoryRequest
import com.example.mis1.data.remote.inventory.dto.InventoryCategory
import com.example.mis1.data.remote.inventory.dto.InventoryGroup
import com.example.mis1.data.remote.inventory.dto.Inventory
import com.example.mis1.data.remote.inventory.dto.InventoryLocation
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface InventoryApi {
    @POST("admin_inventory_list/")
    suspend fun addInventory(@Body request : AddInventoryRequest) :Inventory

    @GET("admin_inventory_list/")
    suspend fun inventoryList(): List<Inventory>

    @GET("admin_inventory_detail/{id}")
    suspend fun inventoryDetail(@Path("id") id: Int) : Inventory

    @GET("admin_location_list/")
    suspend fun locationList(): List<InventoryLocation>

    @GET("admin_location_detail/{id}")
    suspend fun  locationDetail(@Path("id") id: Int) :InventoryLocation

    @GET("admin_inventory_group_list/")
    suspend fun groupList() : List<InventoryGroup>

    @GET("admin_inventory_group_detail/{id}")
    suspend fun groupDetail(@Path("id") id: Int): InventoryGroup

    @GET("admin_inventory_category_list/")
    suspend fun categoryList():List<InventoryCategory>

    @GET("admin_category_detail/{id}")
    suspend fun categoryDetail(@Path("id") id: Int):InventoryCategory

}