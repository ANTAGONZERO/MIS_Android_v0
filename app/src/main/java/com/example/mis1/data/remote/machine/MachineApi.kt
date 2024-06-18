package com.example.mis1.data.remote.machine

import com.example.mis1.data.remote.machine.dto.Machine
import com.example.mis1.data.remote.machine.dto.Reservation
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MachineApi {
    @GET("admin_machine_list/")
    suspend fun machineList():List<Machine>

    @GET("admin_machine_detail/{id}")
    suspend fun machineDetail(@Path("id") id : Int):Machine

    @FormUrlEncoded
    @POST("admin_machine_list/")
    suspend fun addMachine(@FieldMap fields : Map<String,Any>) : Machine

    @GET("machine_reservation_list/")
    suspend fun reservationList():List<Reservation>

    @GET("machine_reservation_detail/{id}")
    suspend fun reservationDetail(@Path("id") id : Int):Reservation

}