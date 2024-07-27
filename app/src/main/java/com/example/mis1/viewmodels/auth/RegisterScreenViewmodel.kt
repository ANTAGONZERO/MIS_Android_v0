package com.example.mis1.viewmodels.auth

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mis1.common.Resource
import com.example.mis1.data.remote.user.dto.RegisterUserRequest
import com.example.mis1.data.remote.user.dto.RegisterUserResponse
import com.example.mis1.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterScreenViewmodel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _user = MutableStateFlow(RegisterUserRequest(
        name = "",
        email = "",
        branch = "",
        currentYear = "",
        degree = "",
        graduationYear = "",
        hostelAddress = "",
        phoneNumber = "",
        college = ""
    ))

    val user: StateFlow<RegisterUserRequest> = _user
    val isStudent = mutableStateOf(true)
    val isGraduationYearDDVisible = mutableStateOf(false)
    val isCollegeDDVisible = mutableStateOf(false)
    val isDepartmentDDVisible = mutableStateOf(false)

    val graduationYearList = mutableListOf("2024","2025","2026","2027","2028")
    val collegeList = mutableListOf(
        "IIT Jammu", "IIT Bombay", "IIT Gandhinagar"
    )

    val departmentList = mutableListOf(
        "CSE", "ECE", "ME", "CE", "EEE", "Aerospace", "Chemical", "Biotech", "Metallurgy", "Physics",
        "Chemistry", "Mathematics", "Civil", "Environmental", "Industrial", "Materials", "Architecture"
    )
    val registerState = mutableStateOf<Resource<RegisterUserResponse>>(Resource.Error(""))
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

    fun showGraduationYearDD(){
        isGraduationYearDDVisible.value = true
    }

    fun showDepartmentDD(){
        isDepartmentDDVisible.value = true
    }

    fun showCollegeDD(){
        isCollegeDDVisible.value = true
    }

    fun hideGraduationYearDD(){
        isGraduationYearDDVisible.value = false
    }

    fun hideDepartmentDD(){
        isDepartmentDDVisible.value = false
    }

    fun hideCollegeDD(){
        isCollegeDDVisible.value = false
    }

    fun updateCollege(college:String){
        _user.value = user.value.copy(college = college)
    }

    fun register(){
        if(registerState.value is Resource.Loading){
            return
        }
        viewModelScope.launch {
            userRepository.register(_user.value).collect {
                registerState.value = it
            }
        }

    }
}