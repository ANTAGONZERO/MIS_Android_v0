package com.example.mis1.repository

import android.util.Log
import com.example.mis1.common.Resource
import com.example.mis1.common.asMap
import com.example.mis1.data.remote.machine.MachineApi
import com.example.mis1.data.remote.machine.dto.Machine
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

    fun addMachine(machine: Machine) = flow<Resource<Machine>> {
        try {
            emit(Resource.Loading(null))
            val response = api.addMachine(machine.asMap())
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(message = "Failed to add machine"))
        }
    }
}
