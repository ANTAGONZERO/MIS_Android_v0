package com.example.mis1.data.remote.inventory.dto


import com.google.gson.annotations.SerializedName

data class Inventory(
    val category: String,
    @SerializedName("created_at")
    val createdAt: String,
    val description: String?,
    val group: String?,
    val id: Int,
    val image: String?,
    @SerializedName("is_hidden")
    val isHidden: Boolean,
    @SerializedName("last_updated_at")
    val lastUpdatedAt: String,
    val location: String,
    val manufacturer: String?,
    val name: String,
    @SerializedName("purchase_cost")
    val purchaseCost: Float?,
    @SerializedName("purchase_date")
    val purchaseDate: String?,
    @SerializedName("stock_available")
    val stockAvailable: Int,
    @SerializedName("stock_total")
    val stockTotal: Int,
    @SerializedName("stock_unit")
    val stockUnit: String,
    @SerializedName("tag_1")
    val tag1: String?,
    @SerializedName("tag_2")
    val tag2: String?,
    @SerializedName("tag_3")
    val tag3: String?,
    @SerializedName("tag_4")
    val tag4: String?,
    val upc: String,
    @SerializedName("warranty_expiration")
    val warrantyExpiration: Any
)