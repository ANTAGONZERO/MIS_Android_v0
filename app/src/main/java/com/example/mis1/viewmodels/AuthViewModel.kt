package com.example.mis1.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mis1.common.Resource
import com.example.mis1.data.TokenManager
import com.example.mis1.repository.MachineRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class AuthViewModel @Inject constructor(
    private val tokenManager: TokenManager,
    private val machineRepository: MachineRepository
) : ViewModel() {


    val authState = mutableStateOf(UNVERIFIED)

    init {
        checkLoginStatus()
    }

    private fun checkLoginStatus() {
        if(tokenManager.token==null){
            authState.value = NOT_AUTHENTICATED
        }
        viewModelScope.launch {
            machineRepository.machineList().collect {
                if (it is Resource.Success) {
                    authState.value = AUTHENTICATED
                }
                if(it is Resource.Error){
                    authState.value = NOT_AUTHENTICATED
                }
            }
        }
    }
    companion object{
        const val UNVERIFIED = "unverified"
        const val NOT_AUTHENTICATED = "not_authenticated"
        const val AUTHENTICATED = "authenticated"
    }
}