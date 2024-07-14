package com.example.mis1.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mis1.R
import com.example.mis1.ui.routes.Screens
import com.example.mis1.viewmodels.SplashScreenViewmodel


@Composable
fun SplashScreen(viewModel:SplashScreenViewmodel = hiltViewModel(), navController:NavController){
    Box{
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .width(96.dp)
                    .height(110.dp),
                painter = painterResource(id = R.drawable.logo), contentDescription ="Logo")
        }
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .width(149.dp)
                    .height(32.dp),
                painter = painterResource(id = R.drawable.powered_by), contentDescription ="powered by")
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
    LaunchedEffect(key1 = viewModel.clientOnBoard.value) {
        if(viewModel.clientOnBoard.value==SplashScreenViewmodel.NOT_ONBOARDED){
            navController.navigate(Screens.OnBoardScreen.path){
                popUpTo(Screens.SplashScreen.path){
                    inclusive  = true
                }
            }
        }
    }
    LaunchedEffect(key1 = viewModel.authState.value) {
        if(viewModel.authState.value == SplashScreenViewmodel.AUTHENTICATED){
            navController.navigate(Screens.ProtectScreen.path){
                popUpTo(Screens.SplashScreen.path){
                    inclusive  = true
                }
            }
        }
        if(viewModel.authState.value == SplashScreenViewmodel.NOT_AUTHENTICATED){
            navController.navigate(Screens.WelcomeScreen.path){
                popUpTo(Screens.SplashScreen.path){
                    inclusive  = true
                }
            }
        }
    }
}
