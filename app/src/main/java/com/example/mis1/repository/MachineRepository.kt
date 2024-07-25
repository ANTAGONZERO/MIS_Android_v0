package com.example.mis1.repository

import com.example.mis1.common.Resource
import com.example.mis1.data.remote.machine.MachineApi
import com.example.mis1.data.remote.machine.dto.AddMachineRequest
import com.example.mis1.data.remote.machine.dto.Machine
import com.example.mis1.data.remote.machine.dto.MachineReservationRequest
import com.example.mis1.data.remote.machine.dto.Reservation
import com.example.mis1.data.remote.machine.dto.ResolvedReservation
import kotlinx.coroutines.flow.Flow

class MachineRepository(
    private val api: MachineApi,
    private val apiCallRepository: ApiCallRepository
) {

    fun machineList(): Flow<Resource<List<Machine>>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to fetch machine list") {
            api.machineList()
        }

    fun addMachine(request: AddMachineRequest): Flow<Resource<Machine>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to add machine") {
            api.addMachine(request)
        }

    fun machineDetail(id: Int): Flow<Resource<Machine>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to fetch machine detail") {
            api.machineDetail(id)
        }

    fun reservationList(): Flow<Resource<List<ResolvedReservation>>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to fetch reservation list") {
            val response = api.reservationList()
            response.map { resolveReservation(it) }
        }

    fun reservationDetail(id: Int): Flow<Resource<Reservation>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to fetch reservation detail") {
            api.reservationDetail(id)
        }

    private suspend fun resolveReservation(reservation: Reservation): ResolvedReservation {
        val machine: Machine = api.machineDetail(reservation.machine)
        return ResolvedReservation(
            id = reservation.id,
            approved = reservation.approved,
            reservedBy = reservation.reservedBy,
            approvedBy = reservation.approvedBy,
            reservedDate = reservation.reservedDate,
            approvedStatus = reservation.approvedStatus,
            createdAt = reservation.createdAt,
            endTime = reservation.endTime,
            lastUpdatedAt = reservation.lastUpdatedAt,
            startTime = reservation.startTime,
            machine = machine
        )
    }

    fun reserveMachine(request: MachineReservationRequest): Flow<Resource<Unit>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to create reservation") {
            api.reserveMachine(request)
        }
}

