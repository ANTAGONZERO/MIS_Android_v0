package com.example.mis1.data

import android.content.SharedPreferences
import com.example.mis1.common.Settings


class SettingsManager(private val sharedPreferences: SharedPreferences) {
    fun getSettings(): Map<Settings, String> {
        val settingsMap = mutableMapOf<Settings, String>()
        Settings.entries.forEach { key ->
            settingsMap[key] = sharedPreferences.getString(key.key, "false") ?: "false"
        }
        return settingsMap
    }

    fun setSettings(settings: Map<Settings, String>) {
        with(sharedPreferences.edit()) {
            settings.forEach { (key, value) ->
                putString(key.key, value)
            }
            apply()
        }
    }
}
