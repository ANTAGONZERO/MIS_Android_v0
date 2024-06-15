package com.example.mis1.data.remote.machine.dto


import com.google.gson.annotations.SerializedName

data class Machine(
    val availability: String,
    val availability1: String,
    val category: String,
    val description: String,
    val id: Int,
    val image: String?,
    val instances: Int,
    val location: String,
    val manufacturer: String,
    val name: String,
    @SerializedName("purchase_cost")
    val purchaseCost: Int?,
    val status: String,
    val status1: String,
    val supervised: Boolean,
    val upc: String
)

