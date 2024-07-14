package com.example.mis1.repository

import android.content.SharedPreferences
import androidx.core.content.edit

class OnboardingRepository (private val sharedPreferences: SharedPreferences) {
    fun isClientOnboard():Boolean{
        return sharedPreferences.getString(KEY, false.toString()) == "true"
    }
    fun setClientOnboarded(){
        sharedPreferences.edit {
            this.putString(KEY,"true")
        }
    }
    companion object{
        private const val KEY = "Onboard"
    }
}