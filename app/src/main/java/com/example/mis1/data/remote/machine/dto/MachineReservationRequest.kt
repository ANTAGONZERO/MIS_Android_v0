package com.example.mis1.data.remote.machine.dto


import com.google.gson.annotations.SerializedName

data class MachineReservationRequest(
    @SerializedName("approved_status")
    val approvedStatus: Int,
    val machine: Int,
    @SerializedName("reserved_by")
    val reservedBy: Int,
    @SerializedName("reserved_from")
    val reservedFrom: String,
    @SerializedName("reserved_till")
    val reservedTill: String
)