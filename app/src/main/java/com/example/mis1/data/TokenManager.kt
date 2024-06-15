package com.example.mis1.data

import android.content.SharedPreferences


class TokenManager(private val sharedPreferences: SharedPreferences) {
    var token: String?
        get() = sharedPreferences.getString(TOKEN_KEY, null)
        set(token) {
            val editor = sharedPreferences.edit()
            editor.putString(TOKEN_KEY, token)
            editor.apply()
        }
    companion object {
        private const val TOKEN_KEY = "auth_token"
    }
}

