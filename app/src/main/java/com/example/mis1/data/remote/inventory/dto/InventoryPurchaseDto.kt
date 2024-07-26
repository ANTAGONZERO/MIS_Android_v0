package com.example.mis1.data.remote.inventory.dto


import com.google.gson.annotations.SerializedName

data class InventoryPurchaseDto(
    @SerializedName("created_at")
    val createdAt: String,
    val id: Int,
    val inventory: Int,
    @SerializedName("last_updated_at")
    val lastUpdatedAt: String,
    @SerializedName("payment_method")
    val paymentMethod: String?,
    @SerializedName("pickup_")
    val pickup: String,
    @SerializedName("purchase_amount")
    val purchaseAmount: String,
    @SerializedName("purchase_datetime")
    val purchaseDatetime: String?,
    @SerializedName("purchased_by")
    val purchasedBy: Int,
    val quantity: Int,
    @SerializedName("return_description")
    val returnDescription: String?,
    @SerializedName("return_reason")
    val returnReason: String?,
    val returned: Boolean,
    @SerializedName("returned_on")
    val returnedOn: String?
)