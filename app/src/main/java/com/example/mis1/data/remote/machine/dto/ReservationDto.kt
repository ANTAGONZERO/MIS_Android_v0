package com.example.mis1.data.remote.machine.dto


import com.google.gson.annotations.SerializedName

data class ReservationDto(
    val approved: String,
    @SerializedName("approved_by")
    val approvedBy: Int?,
    @SerializedName("approved_status")
    val approvedStatus: String,
    val college: Int,
    @SerializedName("created_at")
    val createdAt: String,
    val duration: Double,
    @SerializedName("end_time")
    val endTime: String,
    val id: Int,
    val instances: Int,
    @SerializedName("last_updated_at")
    val lastUpdatedAt: String,
    val location: String,
    val machine: Int,
    val name: String,
    val project: Int,
    @SerializedName("project_name")
    val projectName: String,
    @SerializedName("reserved_by")
    val reservedBy: Int,
    @SerializedName("reserved_date")
    val reservedDate: String,
    val reserver: String,
    @SerializedName("start_time")
    val startTime: String,
    val status: String
)