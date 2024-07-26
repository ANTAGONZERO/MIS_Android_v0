package com.example.mis1.model


data class Tutorial(
    val college: Int,
    val description: String,
    val id: Int,
    val image: String?,
    val name: String,
    val relatedEquipments: List<Int>,
    val relatedInventory: List<Int>,
    val relatedMachines: List<Int>,
    val videos: List<Video>,
    val totalLength: Int,
    val tags:List<String>
)