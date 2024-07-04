package com.example.mis1.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width

import androidx.compose.runtime.Composable

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mis1.R
import com.example.mis1.ui.routes.Screens
import com.example.mis1.viewmodels.AuthViewModel


@Composable
fun SplashScreen(viewModel:AuthViewModel,navController: NavController){
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Image(
            modifier = Modifier
                .width(250.dp)
                .height(48.dp),
            painter = painterResource(id = R.drawable.powered_by), contentDescription ="Logo")
    }
    LaunchedEffect(key1 = viewModel.authState.value) {
        if(viewModel.authState.value == AuthViewModel.AUTHENTICATED){
            navController.navigate(Screens.ProtectScreen.path){
                popUpTo(Screens.SplashScreen.path){
                    inclusive  = true
                }
            }
        }
        if(viewModel.authState.value == AuthViewModel.NOT_AUTHENTICATED){
            navController.navigate(Screens.LoginScreen.path){
                popUpTo(Screens.SplashScreen.path){
                    inclusive  = true
                }
            }
        }
    }
}