package com.example.mis1.ui.routes

sealed class Screens(val path: String) {
    data object Menu : Screens("menu")
    data object Home : Screens("home")
    data object Chat : Screens("chat")
    data object Setting : Screens("setting")
    data object Profile : Screens("profile")
    data object Inventory : Screens("inventory")
    data object Training : Screens("training")
    data object Project : Screens("project")
    data object Record : Screens("record")
}