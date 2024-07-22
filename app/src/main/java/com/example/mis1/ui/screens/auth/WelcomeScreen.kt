package com.example.mis1.ui.screens.auth

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import com.example.mis1.R
import com.example.mis1.ui.composables.button.AuthButton
import com.example.mis1.ui.composables.enums.AuthButtonType
import com.example.mis1.ui.routes.Screens
import com.example.mis1.ui.theme.SPrimarySource
import com.example.mis1.ui.theme.White

@Composable
fun WelcomeScreen(navController:NavHostController){
    Column (modifier=Modifier.fillMaxSize()){
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.43f)
            .background(color = SPrimarySource),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight(),
                painter = painterResource(id = R.drawable.welcome),
                contentDescription = "welcome" )
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
                Spacer(modifier = Modifier.weight(0.8f))
                Text1(text = "Welcome To")
                Text1(text = "MIS")
                Spacer(modifier = Modifier.weight(1.5f))
                Box(modifier = Modifier.fillMaxWidth(0.9f)){
                    AuthButton(type = AuthButtonType.Filled,text = "Register", onClick = {
                        navController.navigate(Screens.Register.path)
                    })
                }
                Spacer(modifier = Modifier.height(16.dp))
                Box(modifier = Modifier.fillMaxWidth(0.9f)){
                    AuthButton(type = AuthButtonType.Surrounded,text = "Login", onClick = {
                        navController.navigate(Screens.Login.path)
                    })
                }
                Spacer(modifier = Modifier.weight(3f))
                Image(
                    modifier = Modifier
                        .width(149.dp)
                        .height(32.dp),
                    painter = painterResource(id = R.drawable.powered_by), contentDescription ="powered by")
                Spacer(modifier = Modifier.height(8.dp))
        }
    }
    val view = LocalView.current
    DisposableEffect(key1 = null) {
        val window = (view.context as Activity).window
        window.statusBarColor = SPrimarySource.toArgb()
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        onDispose {
            window.statusBarColor = White.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = true
        }
    }
}

@Composable
private fun Text1(text:String){
    Text(text = text,
        fontSize = 40.sp,
        fontWeight = FontWeight(700),
        color = SPrimarySource,
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
}