package com.example.mis1.viewmodels

import androidx.lifecycle.ViewModel
import com.example.mis1.repository.OnboardingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardScreenViewmodel @Inject constructor(private val onboardingRepository: OnboardingRepository) :ViewModel(){
    fun setClientOnboarded(){
        onboardingRepository.setClientOnboarded()
    }
}