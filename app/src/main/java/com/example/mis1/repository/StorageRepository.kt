package com.example.mis1.repository

import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.mis1.data.remote.user.dto.User
import com.google.gson.Gson

class StorageRepository(private val sharedPreferences: SharedPreferences) {
    val gson  = Gson()
    var user: User?
        get(){
            return try {
                val jsonString = sharedPreferences.getString(TOKEN_KEY, null)
                gson.fromJson(jsonString, User::class.java)
            }catch (_:Exception){
                null
            }
        }
        set(newUser) {
            val jsonString = gson.toJson(newUser)
            sharedPreferences.edit {
                putString(TOKEN_KEY,jsonString)
            }
        }
    companion object {
        private const val TOKEN_KEY = "user"
    }
}
