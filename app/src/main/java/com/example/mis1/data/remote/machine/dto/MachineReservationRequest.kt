package com.example.mis1.data.remote.machine.dto


import com.google.gson.annotations.SerializedName

data class MachineReservationRequest(
    @SerializedName("end_time")
    val endTime: String,
    val machine: Int,
    val project: Int,
    @SerializedName("reserved_by")
    val reservedBy: Int,
    @SerializedName("reserved_date")
    val reservedDate: String,
    @SerializedName("start_time")
    val startTime: String
)