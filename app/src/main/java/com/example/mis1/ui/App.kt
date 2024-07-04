package com.example.mis1.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mis1.ui.routes.Screens
import com.example.mis1.ui.screens.LoginScreen
import com.example.mis1.ui.screens.ProtectedScreens
import com.example.mis1.ui.screens.SplashScreen
import com.example.mis1.ui.theme.White
import com.example.mis1.viewmodels.AuthViewModel

@Preview
@Composable
fun App(navController: NavHostController = rememberNavController()) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = White
    ) {
        val authViewModel:AuthViewModel = hiltViewModel()
        NavHost(navController = navController, startDestination = Screens.SplashScreen.path){
            composable(Screens.SplashScreen.path){
                SplashScreen(viewModel = authViewModel, navController = navController)
            }
            composable(Screens.ProtectScreen.path){
                ProtectedScreens()
            }
            composable(Screens.LoginScreen.path){
                LoginScreen(navController = navController)
            }
        }
    }
}