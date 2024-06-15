package com.example.mis1.data.remote.inventory.dto


import com.google.gson.annotations.SerializedName

data class AddInventoryRequest(
    val category: String,
    val description: String,
    val location: String,
    val name: String,
    @SerializedName("stock_available")
    val stockAvailable: Int,
    @SerializedName("stock_total")
    val stockTotal: Int,
    @SerializedName("stock_unit")
    val stockUnit: String,
    val tag1: String,
    val tag2: String,
    val upc: String
)