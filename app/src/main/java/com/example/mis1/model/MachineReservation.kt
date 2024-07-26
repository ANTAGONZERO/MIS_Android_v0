package com.example.mis1.model

import com.example.mis1.data.remote.machine.dto.Machine


data class MachineReservation (
    val approved: String,
    val approvedBy: Int?,
    val approvedStatus: String,
    val college: Int,
    val createdAt: String,
    val duration: Double,
    val endTime: String,
    val id: Int,
    val instances: Int,
    val lastUpdatedAt: String,
    val location: String,
    val machine: Machine,
    val name: String,
    val project: Int,
    val projectName: String,
    val reservedBy: Int,
    val reservedDate: String,
    val reserver: String,
    val startTime: String,
    val status: String
)