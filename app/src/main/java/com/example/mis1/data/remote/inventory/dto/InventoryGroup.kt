package com.example.mis1.data.remote.inventory.dto


import com.google.gson.annotations.SerializedName

data class InventoryGroup(
    @SerializedName("created_at")
    val createdAt: String,
    val description: String?,
    val id: Int,
    @SerializedName("last_updated_at")
    val lastUpdatedAt: String,
    val name: String
)