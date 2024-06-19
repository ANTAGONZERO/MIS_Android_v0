package com.example.mis1.data.remote.inventory.dto


data class ResolvedIssuedInventory(
    val createdAt: String,
    val id: Int,
    val inventory: Inventory,
    val issuedBy: Int,
    val issuedFrom: String,
    val issuedTill: String,
    val lastUpdatedAt: String,
    val pickup: String,
    val pickupOn: String?,
    val quantity: Int,
    val returnDescription: String?,
    val returned: String,
    val returnedOn: String?
)