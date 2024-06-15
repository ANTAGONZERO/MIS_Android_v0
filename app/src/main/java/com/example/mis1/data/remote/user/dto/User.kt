package com.example.mis1.data.remote.user.dto


import com.google.gson.annotations.SerializedName

data class User(
    val created: String,
    @SerializedName("current_year")
    val currentYear: Any,
    val degree: Any,
    val department: Any,
    val email: String,
    @SerializedName("graduation_year")
    val graduationYear: Any,
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
    val name: Any,
    @SerializedName("other_position")
    val otherPosition: Any,
    @SerializedName("phone_number")
    val phoneNumber: Any,
    val position: Any,
    @SerializedName("student_id")
    val studentId: Any,
    val username: String
)