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
    data object  LoginScreen : Screens("login")
    data object SplashScreen : Screens("splash_screen")
    data object ProtectScreen : Screens("protected_screen")
    data object WelcomeScreen : Screens("Welcome")
    data object RegisterScreen : Screens("register")
    data object ResetPasswordScreen : Screens("reset_password")
    data object OnBoardScreen : Screens("onboard")
}