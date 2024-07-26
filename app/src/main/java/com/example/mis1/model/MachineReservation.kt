package com.example.mis1.model

import com.example.mis1.data.remote.machine.dto.Machine


data class MachineReservation (
    val approved: String,
    val approvedBy: String?,
    val approvedStatus: String,
    val createdAt: String,
    val endTime: String,
    val id: Int,
    val lastUpdatedAt: String,
    val machine: Machine,
    val reservedBy: Int,
    val reservedDate: String,
    val startTime: String
)