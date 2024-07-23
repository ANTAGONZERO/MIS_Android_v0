package com.example.mis1.repository

import android.content.SharedPreferences
import android.util.Log


class TokenRepository(private val sharedPreferences: SharedPreferences) {
    var token: String?
        get() {
            val token =  sharedPreferences.getString(TOKEN_KEY, null)
            Log.d("getToken",token.toString())
            return token
        }
        set(token) {
            val editor = sharedPreferences.edit()
            editor.putString(TOKEN_KEY, token)
            editor.apply()
        }
    companion object {
        private const val TOKEN_KEY = "auth_token"
    }
}

