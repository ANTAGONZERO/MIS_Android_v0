package com.example.mis1.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mis1.common.Resource
import com.example.mis1.ui.composables.BorderBox
import com.example.mis1.ui.routes.Screens
import com.example.mis1.viewmodels.LoginScreenViewmodel

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginScreenViewmodel = hiltViewModel()
) {
    val email by viewModel.email
    val password by viewModel.password
    val loginState by viewModel.loginState

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.9f)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Login",  modifier = Modifier.padding(bottom = 16.dp))
        BorderBox {
            BasicTextField(
                value = email,
                onValueChange = { viewModel.email.value = it },
                modifier = Modifier
                    .fillMaxWidth(),
                singleLine = true
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        BorderBox {
            BasicTextField(
                value = password,
                onValueChange = { viewModel.password.value = it },
                modifier = Modifier
                    .fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(),
                singleLine = true
            )
        }


        Button(
            onClick = { viewModel.login() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }
        LaunchedEffect(key1 = loginState) {
            if(loginState is Resource.Success){
                navController.navigate(Screens.ProtectScreen.path){
                    popUpTo(Screens.LoginScreen.path) { inclusive = true }
                    launchSingleTop = true
                }
            }
        }
        when (loginState) {
            is Resource.Loading -> {
                CircularProgressIndicator(modifier = Modifier.padding(top = 16.dp))
            }
            is Resource.Success -> {
                Text("Login successful!", color = MaterialTheme.colorScheme.primary, modifier = Modifier.padding(top = 16.dp))
            }
            is Resource.Error -> {
                Text((loginState as Resource.Error).message ?: "", color = MaterialTheme.colorScheme.error, modifier = Modifier.padding(top = 16.dp))
            }
        }
    }
}