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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mis1.R
import com.example.mis1.ui.composables.UserRoleToggle
import com.example.mis1.ui.composables.button.AuthButton
import com.example.mis1.ui.composables.edit_field.LabeledTextField
import com.example.mis1.ui.composables.enums.AuthButtonType
import com.example.mis1.ui.theme.Primary01
import com.example.mis1.ui.theme.SAccentSource
import com.example.mis1.ui.theme.SPrimarySource
import com.example.mis1.viewmodels.RegisterScreenViewmodel

@Composable
fun RegisterScreen(viewModel: RegisterScreenViewmodel = hiltViewModel()) {
    val user by viewModel.user.collectAsState()
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
            text = "Register",
            fontSize = 36.sp,
            fontWeight = FontWeight(500),
            color = SPrimarySource
        )
        Spacer(modifier = Modifier.weight(78f))
        UserRoleToggle(isStudent = viewModel.isStudent.value, onToggle = viewModel::toggleUserRole)
        Spacer(modifier = Modifier.height(20.dp))
        LabeledTextField(
            labelText = "Name", value = user.name,
            onValueChange = viewModel::updateName
        )
        Spacer(modifier = Modifier.height(16.dp))

        LabeledTextField(
            labelText = "Email Address", value = user.email,
            onValueChange = viewModel::updateEmail
        )
        Spacer(modifier = Modifier.height(16.dp))

        LabeledTextField(
            labelText = "Phone Number", value = user.phoneNumber,
            onValueChange = viewModel::updatePhoneNumber
        )
        Spacer(modifier = Modifier.height(16.dp))

        LabeledTextField(
            labelText = "Graduation Year", value = user.graduationYear,
            onValueChange = viewModel::updateGraduationYear
        )

        Spacer(modifier = Modifier.weight(224f))
        AuthButton(text = "Register", type = AuthButtonType.Filled)
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Text(
                text = "Already have an account? ",
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
                    append("Login")
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