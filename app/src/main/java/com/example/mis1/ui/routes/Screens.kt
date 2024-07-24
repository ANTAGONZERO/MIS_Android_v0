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
    data object BookMachine : Screens("book_machine")
    data object  Login : Screens("login")
    data object Splash : Screens("splash_screen")
    data object Protect : Screens("protected_screen")
    data object Welcome : Screens("Welcome")
    data object Register : Screens("register")
    data object ResetPassword : Screens("reset_password")
    data object Onboard : Screens("onboard")
    data object AddProject : Screens("add_project")
    data object IssueInventory : Screens("purchase_inventory")
}