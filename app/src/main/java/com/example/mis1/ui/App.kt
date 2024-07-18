package com.example.mis1.ui

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mis1.ui.routes.Screens
import com.example.mis1.ui.screens.OnboardScreen
import com.example.mis1.ui.screens.ProtectedScreens
import com.example.mis1.ui.screens.SplashScreen
import com.example.mis1.ui.screens.auth.LoginScreen
import com.example.mis1.ui.screens.auth.RegisterScreen
import com.example.mis1.ui.screens.auth.ResetPasswordScreen
import com.example.mis1.ui.screens.auth.WelcomeScreen
import com.example.mis1.ui.theme.White
import com.example.mis1.viewmodels.AppViewmodel

@Preview
@Composable
fun App(navController: NavHostController = rememberNavController(),viewModel:AppViewmodel = hiltViewModel()) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = White
    ) {
        Column (modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            NavHost(navController = navController, startDestination = Screens.SplashScreen.path,
                enterTransition = { fadeIn(tween(150)) },
                exitTransition = { fadeOut(tween(150)) }
            ) {
                composable(Screens.SplashScreen.path) {
                    SplashScreen(navController = navController)
                }
                composable(Screens.ProtectScreen.path) {
                    ProtectedScreens(appViewModel = viewModel)
                }
                composable(Screens.LoginScreen.path) {
                    LoginScreen(navController = navController, appViewModel = viewModel)
                }
                composable(Screens.WelcomeScreen.path) {
                    WelcomeScreen(navController = navController)
                }
                composable(Screens.RegisterScreen.path) {
                    RegisterScreen(navController = navController)
                }
                composable(Screens.ResetPasswordScreen.path){
                    ResetPasswordScreen()
                }
                composable(Screens.OnBoardScreen.path){
                    OnboardScreen(navController = navController)
                }
            }
        }
    }
}