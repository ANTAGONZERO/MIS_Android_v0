package com.example.mis1.data.remote.training.dto


import com.google.gson.annotations.SerializedName

data class TutorialDto(
    val college: Int,
    val description: String,
    val id: Int,
    val image: String?,
    val name: String,
    @SerializedName("related_equipments")
    val relatedEquipments: List<Int>,
    @SerializedName("related_inventory")
    val relatedInventory: List<Int>,
    @SerializedName("related_machines")
    val relatedMachines: List<Int>,
    val videos: List<VideoDto1>
)