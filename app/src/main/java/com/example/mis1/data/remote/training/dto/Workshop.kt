package com.example.mis1.data.remote.training.dto


import com.google.gson.annotations.SerializedName

data class Workshop(
    val attendees: MutableList<Attendee>,
    val college: Int,
    val description: String,
    @SerializedName("eligible_branches")
    val eligibleBranches: List<String>,
    @SerializedName("eligible_years")
    val eligibleYears: List<Int>,
    @SerializedName("from_date")
    val fromDate: String,
    @SerializedName("from_time")
    val fromTime: String,
    val id: Int,
    val image: String?,
    val location: String,
    val title: String,
    @SerializedName("to_date")
    val toDate: String,
    @SerializedName("to_time")
    val toTime: String
)