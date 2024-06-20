package com.example.mis1.data.remote.user.dto


import com.google.gson.annotations.SerializedName

data class User(
    val created: String,
    @SerializedName("current_year")
    val currentYear: String?,
    val degree: String?,
    val department: String?,
    val email: String,
    @SerializedName("graduation_year")
    val graduationYear: String?,
    @SerializedName("hostel_address")
    val hostelAddress: String,
    val id: Int,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_staff")
    val isStaff: Boolean,
    @SerializedName("is_student")
    val isStudent: Boolean,
    @SerializedName("last_login")
    val lastLogin: String,
    val name: String?,
    @SerializedName("other_position")
    val otherPosition: String?,
    @SerializedName("phone_number")
    val phoneNumber: String?,
    val position: String?,
    @SerializedName("student_id")
    val studentId: String?,
    val username: String
)