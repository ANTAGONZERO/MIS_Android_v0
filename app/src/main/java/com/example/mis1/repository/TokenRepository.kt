package com.example.mis1.repository

import android.content.SharedPreferences
import androidx.core.content.edit


class TokenRepository(private val sharedPreferences: SharedPreferences) {
    var token: String?
        get() {
            return sharedPreferences.getString(TOKEN_KEY, null)
        }
        set(token) {
            sharedPreferences.edit {
                putString(TOKEN_KEY, token)
            }
        }
    var refresh: String?
        get(){
            return sharedPreferences.getString(REFRESH_KEY, null)
        }
        set(token) {
            sharedPreferences.edit {
                putString(REFRESH_KEY, token)
            }
        }
    companion object {
        private const val TOKEN_KEY = "auth_token"
        private const val REFRESH_KEY = "refresh_token"
    }
}

