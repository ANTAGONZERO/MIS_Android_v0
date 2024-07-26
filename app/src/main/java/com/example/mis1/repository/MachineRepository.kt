package com.example.mis1.repository

import com.example.mis1.common.Resource
import com.example.mis1.data.remote.machine.MachineApi
import com.example.mis1.data.remote.machine.dto.AddMachineRequest
import com.example.mis1.data.remote.machine.dto.Machine
import com.example.mis1.data.remote.machine.dto.MachineReservationRequest
import com.example.mis1.data.remote.machine.dto.ReservationDto
import com.example.mis1.model.MachineReservation
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

    fun reservationList(): Flow<Resource<List<MachineReservation>>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to fetch reservation list") {
            val response = api.reservationList()
            val result = mutableListOf<MachineReservation>()
            response.forEach {
                try {
                    result.add(resolveReservation(it))
                    emit(Resource.Success(result))
                } catch (_: Exception) {

                }
            }
            result
        }

    fun reservationDetail(id: Int): Flow<Resource<ReservationDto>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to fetch reservation detail") {
            api.reservationDetail(id)
        }

    private suspend fun resolveReservation(reservation: ReservationDto): MachineReservation {
        val machine: Machine = api.machineDetail(reservation.machine)
        return MachineReservation(
            approved = reservation.approved,
            approvedBy = reservation.approvedBy,
            approvedStatus = reservation.approvedStatus,
            college = reservation.college,
            createdAt = reservation.createdAt,
            duration = reservation.duration,
            endTime = reservation.endTime,
            id = reservation.id,
            instances = reservation.instances,
            lastUpdatedAt = reservation.lastUpdatedAt,
            location = reservation.location,
            machine = machine,
            name = reservation.name,
            project = reservation.project,
            projectName = reservation.projectName,
            reservedBy = reservation.reservedBy,
            reservedDate = reservation.reservedDate,
            reserver = reservation.reserver,
            startTime = reservation.startTime,
            status = reservation.status
        )
    }

    fun reserveMachine(request: MachineReservationRequest): Flow<Resource<ReservationDto>> =
        apiCallRepository.protectedApiCall(errorMessage = "Failed to create reservation") {
            api.reserveMachine(request)
        }
}

