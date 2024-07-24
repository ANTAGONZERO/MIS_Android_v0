package com.example.mis1.data.remote.inventory.dto


import com.google.gson.annotations.SerializedName

data class PurchaseInventoryRequest(
    val inventory: Int,
    val pickup: Int,
    val project:Int,
    @SerializedName("purchased_by")
    val purchasedBy: Int,
    val quantity: Int
)