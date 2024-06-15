package com.example.mis1.data.remote.equipment.dto


import com.google.gson.annotations.SerializedName

data class Equipment(
    val category: String,
    @SerializedName("created_at")
    val createdAt: String,
    val description: String,
    val id: Int,
    val image: String?,
    val instances: Int,
    @SerializedName("last_updated_at")
    val lastUpdatedAt: String,
    val location: String,
    val manufacturer: String,
    val name: String,
    @SerializedName("purchase_cost")
    val purchaseCost: String,
    @SerializedName("purchase_date")
    val purchaseDate: String?,
    val status: String,
    val upc: String,
    @SerializedName("warranty_expiration")
    val warrantyExpiration: String?
)