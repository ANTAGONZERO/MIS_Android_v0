package com.example.mis1.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mis1.common.Resource
import com.example.mis1.data.TokenManager
import com.example.mis1.data.remote.user.dto.UserCredentials
import com.example.mis1.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val userRepository : UserRepository,
    private val tokenManager : TokenManager
) : ViewModel() {
    private val _email = mutableStateOf("")
    private val _password = mutableStateOf("")
    private val _loading = mutableStateOf(false)
    fun login() {

        if(_loading.value)
            return

        viewModelScope.launch {
            userRepository.login(UserCredentials(email = _email.value, password = _password.value))
                .collect {
                    when (it) {
                        is Resource.Error -> _loading.value = false
                        is Resource.Loading -> _loading.value = true
                        is Resource.Success -> _loading.value = false
                    }
                }
        }
    }
}