package com.example.mis1.common

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun <T> T.asMap(): Map<String, Any> {
    val gson = Gson()
    val json = gson.toJson(this)
    val type = object : TypeToken<Map<String, Any>>() {}.type
    return gson.fromJson(json, type);
}