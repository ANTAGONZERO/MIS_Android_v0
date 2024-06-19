package com.example.mis1.common

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlin.reflect.full.memberProperties

fun <T> T.asMap(): Map<String, Any> {
    val gson = Gson()
    val json = gson.toJson(this)
    val type = object : TypeToken<Map<String, Any>>() {}.type
    return gson.fromJson(json, type)
}

fun Any.searchInProperties(search: String): Boolean {
    val lowerSearch = search.lowercase()
    this::class.memberProperties.forEach { property ->
        val value = property.getter.call(this)
        if (value != null && value.isPrimitiveType()) {
            return value.toString().contains(lowerSearch, true)
        }
    }
    return false
}

private fun Any.isPrimitiveType(): Boolean {
    return when (this) {
        is String, is Int, is Float, is Double, is Boolean,
        is Byte, is Short, is Long, is Char -> true
        else -> false
    }
}
