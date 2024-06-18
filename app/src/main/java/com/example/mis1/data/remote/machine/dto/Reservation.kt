package com.example.mis1.data.remote.machine.dto


import com.google.gson.annotations.SerializedName

data class Reservation(
    val approved: String,
    @SerializedName("approved_by")
    val approvedBy: String?,
    @SerializedName("approved_status")
    val approvedStatus: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("end_time")
    val endTime: String,
    val id: Int,
    @SerializedName("last_updated_at")
    val lastUpdatedAt: String,
    val machine: Int,
    @SerializedName("reserved_by")
    val reservedBy: Int,
    @SerializedName("reserved_date")
    val reservedDate: String,
    @SerializedName("start_time")
    val startTime: String
)