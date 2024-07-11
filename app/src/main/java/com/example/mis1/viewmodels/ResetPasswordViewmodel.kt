package com.example.mis1.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResetPasswordViewmodel @Inject constructor() : ViewModel() {
    val email = mutableStateOf("")
    val otp = mutableStateOf("")
    val newPassword = mutableStateOf("")
    val repeatNewPassword = mutableStateOf("")
    val saveEnabled = mutableStateOf(false)
    val newPasswordVisible = mutableStateOf(false)
    val repeatNewPasswordVisible = mutableStateOf(false)
    fun updateEmail(value: String) {
        email.value = value
    }

    fun updateOTP(s: String, isMaxLength: Boolean) {
        otp.value = s
    }

    fun updateNewPassword(value: String) {
        newPassword.value = value
        updateSaveEnabled()
    }

    fun updateRepeatNewPassword(value: String) {
        repeatNewPassword.value = value
        updateSaveEnabled()
    }
    private fun updateSaveEnabled() {
        saveEnabled.value =
            !(newPassword.value.isEmpty() && repeatNewPassword.value.isEmpty()) && (newPassword.value == repeatNewPassword.value)
    }
    fun toggleNewPasswordVisibility(){
        newPasswordVisible.value = !newPasswordVisible.value
    }

    fun toggleRepeatNewPasswordVisibility(){
        repeatNewPasswordVisible.value = !repeatNewPasswordVisible.value
    }
}