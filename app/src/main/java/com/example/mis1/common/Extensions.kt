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
    var found = false
    this::class.memberProperties.forEach { property ->
        val value = property.getter.call(this)
        val foundInProperty = if (value == null) {
            false
        } else if (value is String) {
            value.contains(search, true)
        } else if (value.isPrimitiveType()) {
            value.toString().contains(search, true)
        } else {
            false
        }
        if (foundInProperty)
            found = true
    }
    return found
}

private fun Any.isPrimitiveType(): Boolean {
    return when (this) {
        is String, is Int, is Float, is Double, is Boolean,
        is Byte, is Short, is Long, is Char -> true
        else -> false
    }
}

fun Int.toTwoDigitString(): String =
    if (this < 0)
        "00"
    else if (this > 9) {
        "$this"
    } else {
        "0$this"
    }
