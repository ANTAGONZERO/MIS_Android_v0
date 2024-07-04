package com.example.mis1.data.remote.machine.dto


import com.google.gson.annotations.SerializedName

data class AddMachineRequest(
    val availability: Int,
    val availability1: Int,
    val category: String,
    val description: String,
    val image: Any,
    val instances: Int,
    val location: String,
    val manufacturer: String,
    val name: String,
    @SerializedName("purchase_cost")
    val purchaseCost: Float?,
    val status: Int,
    val status1: Int,
    val supervised: Boolean,
    val upc: String
)