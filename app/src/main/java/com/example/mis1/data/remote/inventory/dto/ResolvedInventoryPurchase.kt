package com.example.mis1.data.remote.inventory.dto


data class ResolvedInventoryPurchase(
    val createdAt: String,
    val id: Int,
    val inventory: Inventory,
    val lastUpdatedAt: String,
    val paymentMethod: String?,
    val pickup: String,
    val purchaseAmount: String,
    val purchaseDatetime: String?,
    val purchasedBy: Int,
    val quantity: Int,
    val returnDescription: String?,
    val returnReason: String?,
    val returned: Boolean,
    val returnedOn: String?
)