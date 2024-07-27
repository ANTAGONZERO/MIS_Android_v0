package com.example.mis1.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mis1.model.Settings
import com.example.mis1.repository.SettingsRepository
import com.example.mis1.ui.routes.SettingTabs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SettingsScreenViewmodel @Inject constructor(
    private val settingsRepository: SettingsRepository
):ViewModel(
) {
    val visibleTab = mutableStateOf(SettingTabs.Notification)

    private val _settings = MutableStateFlow(settingsRepository.getSettings())
    val settings: StateFlow<Map<Settings, String>> = _settings

    fun toggleSetting(setting: Settings) {
        _settings.update { currentSettings ->
            currentSettings.toMutableMap().apply {
                val newValue = if (currentSettings[setting] == "true") "false" else "true"
                this[setting] = newValue
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        settingsRepository.setSettings(_settings.value)
    }
    fun showNotificationTab(){
        visibleTab.value = SettingTabs.Notification
    }
    fun  showPrivacyTab(){
        visibleTab.value = SettingTabs.Privacy
    }
}