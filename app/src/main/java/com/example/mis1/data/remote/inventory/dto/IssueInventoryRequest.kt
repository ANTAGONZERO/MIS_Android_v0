package com.example.mis1.data.remote.inventory.dto


import com.google.gson.annotations.SerializedName

data class IssueInventoryRequest(
    val inventory: Int,
    @SerializedName("issued_by")
    val issuedBy: Int,
    @SerializedName("issued_from")
    val issuedFrom: String,
    @SerializedName("issued_till")
    val issuedTill: String,
    val pickup: Int,
    val quantity: Int
)