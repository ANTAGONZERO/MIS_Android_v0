package com.example.mis1.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mis1.R
import com.example.mis1.common.Resource
import com.example.mis1.ui.composables.button.AuthButton
import com.example.mis1.ui.composables.edit_field.LabeledTextField
import com.example.mis1.ui.composables.enums.AuthButtonType
import com.example.mis1.ui.routes.Screens
import com.example.mis1.ui.theme.Primary01
import com.example.mis1.ui.theme.SAccentSource
import com.example.mis1.ui.theme.SPrimarySource
import com.example.mis1.viewmodels.LoginScreenViewmodel

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginScreenViewmodel = hiltViewModel()
) {
    val email by viewModel.email
    val password by viewModel.password
    val loginState by viewModel.loginState
    LaunchedEffect(key1 = loginState) {
        if (loginState is Resource.Success) {
            navController.navigate(Screens.ProtectScreen.path) {
                popUpTo(Screens.LoginScreen.path) { inclusive = true }
                launchSingleTop = true
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        Image(
            modifier = Modifier
                .width(110.dp)
                .height(49.dp),
            painter = painterResource(id = R.drawable.maker_bhavan_foundation_logo),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Login",
            fontSize = 36.sp,
            fontWeight = FontWeight(500),
            color = SPrimarySource
        )
        Spacer(modifier = Modifier.weight(78f))
        LabeledTextField(labelText = "Email Address", value = email,
            onValueChange = { viewModel.email.value = it })
        Spacer(modifier = Modifier.height(16.dp))
        LabeledTextField(
            labelText = "Password", value = password,
            onValueChange = { viewModel.password.value = it },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))
        ClickableText(
            modifier = Modifier.fillMaxWidth(),
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(400),
                        color = Primary01
                    )
                ) {
                    append("Forgot Password?")
                }
            }) {
                navController.navigate(Screens.ResetPasswordScreen.path)
        }
        Spacer(modifier = Modifier.weight(224f))
        AuthButton(text = "Login", type = AuthButtonType.Filled, onClick = viewModel::login)
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Text(
                text = "Don’t have an account? ",
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                color = Primary01
            )
            ClickableText(text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(400),
                        color = SAccentSource
                    )
                ) {
                    append("Register")
                }
            }) {

            }
        }

        Spacer(modifier = Modifier.height(32.dp))
        Image(
            modifier = Modifier
                .width(149.dp)
                .height(32.dp),
            painter = painterResource(id = R.drawable.powered_by), contentDescription = "powered by"
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}

//when (loginState) {
//            is Resource.Loading -> {
//                CircularProgressIndicator(modifier = Modifier.padding(top = 16.dp))
//            }
//
//            is Resource.Success -> {
//                Text(
//                    "Login successful!",
//                    color = MaterialTheme.colorScheme.primary,
//                    modifier = Modifier.padding(top = 16.dp)
//                )
//            }
//
//            is Resource.Error -> {
//                Text(
//                    (loginState as Resource.Error).message ?: "",
//                    color = MaterialTheme.colorScheme.error,
//                    modifier = Modifier.padding(top = 16.dp)
//                )
//            }
//        }