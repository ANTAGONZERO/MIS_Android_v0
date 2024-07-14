package com.example.mis1.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mis1.common.Resource
import com.example.mis1.repository.TokenRepository
import com.example.mis1.repository.MachineRepository
import com.example.mis1.repository.OnboardingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class SplashScreenViewmodel @Inject constructor(
    private val tokenRepository: TokenRepository,
    private val machineRepository: MachineRepository,
    private val onboardingRepository: OnboardingRepository
) : ViewModel() {


    val authState = mutableStateOf(UNVERIFIED)

    val clientOnBoard = mutableStateOf(UNVERIFIED)

    init {
        checkClientOnboard()
        if(clientOnBoard.value== ONBOARDED)
            checkLoginStatus()
    }

    private fun checkClientOnboard(){
        if(onboardingRepository.isClientOnboard()){
            clientOnBoard.value = ONBOARDED
        }
        else{
            clientOnBoard.value = NOT_ONBOARDED
        }
    }

    private fun checkLoginStatus() {
        if(tokenRepository.token==null){
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

        const val ONBOARDED = "client_onboarded"
        const val NOT_ONBOARDED = "not_onboarded"

    }
}