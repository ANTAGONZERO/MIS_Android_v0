package com.example.mis1.repository

import android.util.Log
import com.example.mis1.common.Resource
import com.example.mis1.data.remote.machine.MachineApi
import com.example.mis1.data.remote.machine.dto.AddMachineRequest
import com.example.mis1.data.remote.machine.dto.Machine
import com.example.mis1.data.remote.machine.dto.Reservation
import com.example.mis1.data.remote.machine.dto.ResolvedReservation
import kotlinx.coroutines.flow.flow

class MachineRepository (
    private val api: MachineApi
) {

    fun machineList() = flow<Resource<List<Machine>>> {
        try {
            emit(Resource.Loading(null))
            val response = api.machineList()
            emit(Resource.Success(response))
        } catch (e: Exception) {
            Log.d("Exception happened",e.toString())
            emit(Resource.Error(message = "Failed to fetch machine list"))
        }
    }

    fun addMachine(request: AddMachineRequest) = flow<Resource<Machine>> {
        try {
            emit(Resource.Loading(null))
            val response = api.addMachine(request)
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(message = "Failed to add machine"))
        }
    }

    fun machineDetail(id: Int) = flow<Resource<Machine>> {
        try {
            emit(Resource.Loading(null))
            val response = api.machineDetail(id)
            emit(Resource.Success(response))
        } catch (e: Exception) {
            Log.d("Exception happened", e.toString())
            emit(Resource.Error(message = "Failed to fetch machine detail"))
        }
    }

    fun reservationList() = flow<Resource<List<ResolvedReservation>>> {
        try {
            emit(Resource.Loading(null))
            val response = api.reservationList()
            val resolvedReservationList: List<ResolvedReservation> =
                response.map { resolveReservation(it) }
            emit(Resource.Success(resolvedReservationList))
        } catch (e: Exception) {
            Log.d("Exception happened", e.toString())
            emit(Resource.Error(message = "Failed to fetch reservation list"))
        }
    }

    fun reservationDetail(id: Int) = flow<Resource<Reservation>> {
        try {
            emit(Resource.Loading(null))
            val response = api.reservationDetail(id)
            emit(Resource.Success(response))
        } catch (e: Exception) {
            Log.d("Exception happened", e.toString())
            emit(Resource.Error(message = "Failed to fetch reservation detail"))
        }
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
}
