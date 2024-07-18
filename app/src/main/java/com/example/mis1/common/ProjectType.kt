package com.example.mis1.common

enum class ProjectType(val id: String, val displayName: String) {
    ACADEMIC("1", "Academic"),
    RESEARCH("2", "Research"),
    PERSONAL("3", "Personal"),
    OTHER("4", "Other");

    companion object {
        fun fromId(id: String): ProjectType? {
            return entries.find { it.id == id }
        }

        fun fromName(name: String): ProjectType? {
            return entries.find { it.displayName == name }
        }
    }
}
