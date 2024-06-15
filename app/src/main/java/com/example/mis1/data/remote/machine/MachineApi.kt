package com.example.mis1.data.remote.machine

import com.example.mis1.data.remote.machine.dto.Machine
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MachineApi {
    @GET("admin_machine_list/")
    suspend fun machineList():List<Machine>

    @FormUrlEncoded
    @POST("admin_machine_list/")
    suspend fun addMachine(@FieldMap fields : Map<String,Any>) : Machine

}