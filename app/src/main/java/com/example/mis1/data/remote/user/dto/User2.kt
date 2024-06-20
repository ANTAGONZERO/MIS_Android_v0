package com.example.mis1.data.remote.user.dto


import com.google.gson.annotations.SerializedName

data class User2(
    @SerializedName("current_year")
    val currentYear: Int?,
    val degree: String?,
    val department: String,
    val email: String,
    @SerializedName("graduation_year")
    val graduationYear: String?,
    @SerializedName("hostel_address")
    val hostelAddress: String,
    val id: Int,
    @SerializedName("is_student")
    val isStudent: Boolean,
    val name: String,
    @SerializedName("other_position")
    val otherPosition: String?,
    @SerializedName("phone_number")
    val phoneNumber: String,
    val position: String?,
    @SerializedName("student_id")
    val studentId: String?
)