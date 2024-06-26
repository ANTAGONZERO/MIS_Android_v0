package com.example.mis1.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mis1.ui.routes.SettingTabs
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsScreenViewmodel @Inject constructor():ViewModel(
) {
    val visibleTab = mutableStateOf(SettingTabs.Notification)
    fun showNotificationTab(){
        visibleTab.value = SettingTabs.Notification
    }
    fun  showPrivacyTab(){
        visibleTab.value = SettingTabs.Privacy
    }
}