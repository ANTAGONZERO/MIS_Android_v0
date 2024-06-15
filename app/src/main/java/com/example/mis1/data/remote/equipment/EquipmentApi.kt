package com.example.mis1.data.remote.equipment

import com.example.mis1.data.remote.equipment.dto.Equipment
import retrofit2.http.GET
import retrofit2.http.Path

interface EquipmentApi {
    @GET("admin_equipment_list/")
    suspend fun getEquipmentList():List<Equipment>

    @GET("admin_equipment_list/{id}")
    suspend fun getEquipmentDetail(@Path("id") id : Int):Equipment
}