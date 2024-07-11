package com.example.mis1.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mis1.data.remote.user.dto.RegisterUserRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class RegisterScreenViewmodel @Inject constructor() : ViewModel() {

    private val _user = MutableStateFlow(RegisterUserRequest(
        name = "",
        email = "",
        branch = "",
        currentYear = "",
        degree = "",
        graduationYear = "",
        hostelAddress = "",
        phoneNumber = ""
    ))
    val user: StateFlow<RegisterUserRequest> = _user
    val isStudent = mutableStateOf(true)
    fun updateBranch(branch: String) {
        _user.value = _user.value.copy(branch = branch)
    }

    fun updateCurrentYear(currentYear: String) {
        _user.value = _user.value.copy(currentYear = currentYear)
    }

    fun updateDegree(degree: String) {
        _user.value = _user.value.copy(degree = degree)
    }

    fun updateEmail(email: String) {
        _user.value = _user.value.copy(email = email)
    }

    fun updateGraduationYear(graduationYear: String) {
        _user.value = _user.value.copy(graduationYear = graduationYear)
    }

    fun updateHostelAddress(hostelAddress: String) {
        _user.value = _user.value.copy(hostelAddress = hostelAddress)
    }

    fun updateName(name: String) {
        _user.value = _user.value.copy(name = name)
    }

    fun updatePhoneNumber(phoneNumber: String) {
        _user.value = _user.value.copy(phoneNumber = phoneNumber)
    }

    fun toggleUserRole(){
        isStudent.value  = !isStudent.value
    }
}