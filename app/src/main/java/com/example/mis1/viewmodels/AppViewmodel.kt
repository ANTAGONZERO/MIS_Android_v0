package com.example.mis1.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.mis1.data.remote.user.dto.User
import com.example.mis1.repository.StorageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppViewmodel @Inject constructor(
    storageRepository: StorageRepository
) :ViewModel(){
    var user by mutableStateOf<User?>(null)
        private set
    init {
        user = storageRepository.user
    }
    fun updateUser(newUser: User){
        user = newUser
    }
}