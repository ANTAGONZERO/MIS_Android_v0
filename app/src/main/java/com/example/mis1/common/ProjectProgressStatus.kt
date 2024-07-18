package com.example.mis1.common

enum class ProjectProgressStatus(val id: String, val displayName: String) {
    NOT_STARTED("1", "Not Started"),
    IN_PROGRESS("2", "In Progress"),
    COMPLETED("3", "Completed");

    companion object {
        fun fromId(id: String): ProjectProgressStatus? {
            return entries.find { it.id == id }
        }

        fun fromName(name: String): String? {
            return entries.find { it.displayName == name }?.id
        }
    }
}