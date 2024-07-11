package com.example.mis1.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mis1.R
import com.example.mis1.ui.composables.button.AuthButton
import com.example.mis1.ui.composables.edit_field.LabeledTextField
import com.example.mis1.ui.composables.enums.AuthButtonType
import com.example.mis1.ui.theme.Primary05
import com.example.mis1.ui.theme.SPrimarySource
import com.example.mis1.viewmodels.ResetPasswordViewmodel

@Composable
fun ResetPasswordScreen(viewModel: ResetPasswordViewmodel = hiltViewModel()) {
    Column(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .fillMaxHeight(),
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        Image(
            modifier = Modifier
                .width(110.dp)
                .height(49.dp)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.maker_bhavan_foundation_logo),
            contentDescription = "logo"
        )
        Spacer(modifier = Modifier.weight(48f))
        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = "No Worries!",
            fontSize = 36.sp,
            fontWeight = FontWeight(500),
            color = SPrimarySource
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .padding(start = 4.dp)
        ) {
            Text(
                text = " Let's fix this so you can get back to managing and accessing your tech equipment seamlessly.",
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                color = Primary05,
            )
        }
        Spacer(modifier = Modifier.weight(24f))
        LabeledTextField(
            labelText = "Email address",
            value = viewModel.email.value,
            onValueChange = viewModel::updateEmail
        )
        Spacer(modifier = Modifier.weight(24f))
        AuthButton(type = AuthButtonType.Filled, text = "Reset Password")
        Spacer(modifier = Modifier.weight(308f))
        Image(
            modifier = Modifier
                .width(149.dp)
                .height(32.dp)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.powered_by), contentDescription = "powered by"
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}