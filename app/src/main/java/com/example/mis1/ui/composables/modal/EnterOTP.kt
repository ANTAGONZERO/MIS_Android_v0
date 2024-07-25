package com.example.mis1.ui.composables.modal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.ui.composables.button.AuthButton
import com.example.mis1.ui.composables.edit_field.OTPInputField
import com.example.mis1.ui.theme.Primary01
import com.example.mis1.ui.theme.Primary02
import com.example.mis1.ui.theme.Primary05
import com.example.mis1.ui.theme.RoundedTopRectangleXXL
import com.example.mis1.ui.theme.SPrimarySource
import com.example.mis1.ui.theme.Size120
import com.example.mis1.ui.theme.Size40
import com.example.mis1.viewmodels.auth.ResetPasswordViewmodel

@Composable
fun EnterOTP(viewmodel: ResetPasswordViewmodel) {
    val code = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFFFFFFFF), shape = RoundedTopRectangleXXL)
            .padding(start = 24.dp, top = 24.dp, end = 24.dp, bottom = 24.dp),
    ) {
        Text(
            text = "Check your email",
            fontSize = 28.sp,
            fontWeight = FontWeight(500),
            color = Primary01
        )
        Spacer(modifier = Modifier.height(Size40))
        Text(
            text = "We have sent a 6 digit code to:",
            fontSize = 16.sp,
            fontWeight = FontWeight(400),
            color = Primary05
        )
        Spacer(modifier = Modifier.height(Size40))
        Text(
            text = "anjali.jain@gmail.com",
            fontSize = 16.sp,
            fontWeight = FontWeight(400),
            color = Primary02
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Enter 6 digit code",
            fontSize = 16.sp,
            fontWeight = FontWeight(400),
            color = Primary05
        )
        Spacer(modifier = Modifier.height(8.dp))
        OTPInputField(
            modifier = Modifier.fillMaxWidth(),
            otpText = viewmodel.otp.value,
            onOtpModified = viewmodel::updateOTP)
        Spacer(modifier = Modifier.height(Size120))
        AuthButton(text = "Continue")
        Spacer(modifier = Modifier.height(Size120))
        TextButton(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(0.dp),
            onClick = { /* Handle resend code action */ }) {
            Text(
                modifier = Modifier.padding(0.dp), text = "Resend Code", fontSize = 16.sp,
                fontWeight = FontWeight(500),
                color = SPrimarySource
            )
        }
    }
}
