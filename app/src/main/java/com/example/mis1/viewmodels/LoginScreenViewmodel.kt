package com.example.mis1.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mis1.common.Resource
import com.example.mis1.data.TokenManager
import com.example.mis1.data.remote.user.dto.LoginUserResponse
import com.example.mis1.data.remote.user.dto.UserCredentials
import com.example.mis1.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class LoginScreenViewmodel @Inject constructor(
    private val userRepository : UserRepository,
    private val tokenManager : TokenManager
) : ViewModel() {
    val email = mutableStateOf("")
    val password = mutableStateOf("")
    val loginState  = mutableStateOf<Resource<LoginUserResponse>>(Resource.Error(message = null))
    fun login() {

        if(loginState.value is Resource.Loading)
            return

        viewModelScope.launch {
            userRepository.login(UserCredentials(email = email.value, password = password.value))
                .collect {
                    loginState.value = it
                    if (it.data!=null){
                        tokenManager.token = it.data.access
                    }
                }
        }
    }
}