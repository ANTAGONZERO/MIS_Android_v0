package com.example.mis1.ui.composables.modal

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.R
import com.example.mis1.ui.composables.button.AuthButton
import com.example.mis1.ui.composables.edit_field.LabeledTextField
import com.example.mis1.ui.composables.enums.AuthButtonType
import com.example.mis1.ui.theme.Primary01
import com.example.mis1.ui.theme.Primary05
import com.example.mis1.ui.theme.RoundedTopRectangleXL
import com.example.mis1.viewmodels.ResetPasswordViewmodel

@Composable
fun EnterNewPassword(viewModel: ResetPasswordViewmodel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFFFFFFFF), shape = RoundedTopRectangleXL)
            .padding(start = 24.dp, top = 24.dp, end = 24.dp, bottom = 24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Update your password",
            fontSize = 28.sp,
            fontWeight = FontWeight(500),
            color = Primary01
        )
        LabeledTextField(
            labelText = "New Password",
            value = viewModel.newPassword.value,
            onValueChange = viewModel::updateNewPassword,
            visualTransformation = if (viewModel.newPasswordVisible.value) VisualTransformation.None
            else PasswordVisualTransformation(),
            rightComposable = { Eye(onClick = viewModel::toggleNewPasswordVisibility) }
        )
        LabeledTextField(
            labelText = "Repeat New Password",
            value = viewModel.repeatNewPassword.value,
            onValueChange = viewModel::updateRepeatNewPassword,
            visualTransformation = if (viewModel.repeatNewPasswordVisible.value) VisualTransformation.None
            else PasswordVisualTransformation(),
            rightComposable = { Eye(onClick = viewModel::toggleRepeatNewPasswordVisibility)}
        )
        AuthButton(
            type = if (viewModel.saveEnabled.value) AuthButtonType.Filled
            else AuthButtonType.Disabled,
            text = "Save"
        )
    }
}

@Composable
private fun Eye(onClick: () -> Unit = {}) {
    Icon(
        modifier = Modifier
            .padding(1.dp)
            .width(24.dp)
            .height(24.dp)
            .clickable(onClick = onClick),
        painter = painterResource(id = R.drawable.eye),
        contentDescription = null,
        tint = Primary05
    )
}