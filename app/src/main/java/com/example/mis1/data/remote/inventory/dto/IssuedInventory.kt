package com.example.mis1.data.remote.inventory.dto


import com.google.gson.annotations.SerializedName

data class IssuedInventory(
    val college: Int,
    @SerializedName("created_at")
    val createdAt: String,
    val id: Int,
    val inventory: Int,
    @SerializedName("issued_by")
    val issuedBy: Int,
    @SerializedName("issued_from")
    val issuedFrom: String,
    @SerializedName("issued_till")
    val issuedTill: String,
    @SerializedName("last_updated_at")
    val lastUpdatedAt: String,
    val name: String,
    @SerializedName("pickup_")
    val pickup: String,
    @SerializedName("pickup_on")
    val pickupOn: String,
    val project: Int,
    @SerializedName("project_name")
    val projectName: String,
    val quantity: Int,
    @SerializedName("return_description")
    val returnDescription: String?,
    @SerializedName("returned_")
    val returned: String,
    @SerializedName("returned_on")
    val returnedOn: String,
    val taker: String
)