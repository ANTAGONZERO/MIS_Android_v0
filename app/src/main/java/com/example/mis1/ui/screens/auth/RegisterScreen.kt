package com.example.mis1.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mis1.R
import com.example.mis1.common.Resource
import com.example.mis1.ui.composables.UserRoleToggle
import com.example.mis1.ui.composables.button.AuthButton
import com.example.mis1.ui.composables.edit_field.LabeledTextField
import com.example.mis1.ui.composables.enums.AuthButtonType
import com.example.mis1.ui.routes.Screens
import com.example.mis1.ui.theme.Primary01
import com.example.mis1.ui.theme.Primary05
import com.example.mis1.ui.theme.Primary07
import com.example.mis1.ui.theme.RoundedRectangleM
import com.example.mis1.ui.theme.SAccentSource
import com.example.mis1.ui.theme.SPrimary50
import com.example.mis1.ui.theme.SPrimarySource
import com.example.mis1.ui.theme.SizeNone
import com.example.mis1.viewmodels.RegisterScreenViewmodel

@Composable
fun RegisterScreen(navController: NavController,viewModel: RegisterScreenViewmodel = hiltViewModel()) {
    val user by viewModel.user.collectAsState()
    LaunchedEffect(key1 = viewModel.registerState.value) {
        if(viewModel.registerState.value is Resource.Success){
            navController.navigate(Screens.Login.path){
                popUpTo(Screens.Welcome.path){
                    inclusive = false
                }
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
            text = "Register",
            fontSize = 36.sp,
            fontWeight = FontWeight(500),
            color = SPrimarySource
        )
        Spacer(modifier = Modifier.height(8.dp))
        UserRoleToggle(isStudent = viewModel.isStudent.value, onToggle = viewModel::toggleUserRole)
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            Modifier
                .weight(1000f)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            LabeledTextField(
                labelText = "Name", value = user.name,
                onValueChange = viewModel::updateName
            )
            LabeledTextField(
                labelText = "Email Address", value = user.email,
                onValueChange = viewModel::updateEmail
            )
            LabeledTextField(
                labelText = "Phone Number", value = user.phoneNumber,
                onValueChange = viewModel::updatePhoneNumber,
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone)
            )
            GraduationYearDropDown(viewModel = viewModel)
            DepartmentDropDown(viewModel = viewModel)
            CollegeDropDown(viewModel = viewModel)
            LabeledTextField(
                labelText = "Degree", value = user.degree,
                onValueChange = viewModel::updateDegree
            )
            LabeledTextField(
                labelText = "Current Year", value = user.currentYear,
                onValueChange = viewModel::updateCurrentYear,
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )
            LabeledTextField(
                labelText = "Hostel address", value = user.hostelAddress,
                onValueChange = viewModel::updateHostelAddress
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        AuthButton(text = "Register", type = AuthButtonType.Filled, onClick = viewModel::register)
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
                navController.navigate(Screens.Login.path){
                    popUpTo(Screens.Welcome.path){
                        inclusive = false
                    }
                }
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

@Composable
private fun DropDownInputField(currentSelection: String, onShowDropDown: () -> Unit, hint: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(width = SizeNone, color = Primary07, shape = RoundedRectangleM)
            .clip(RoundedRectangleM)
            .clickable(onClick = onShowDropDown)
            .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = currentSelection.ifEmpty { hint },
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                color = Primary05
            )
        )
    }
}

@Composable
private fun GraduationYearDropDown(viewModel: RegisterScreenViewmodel) {
    val user by viewModel.user.collectAsState()
    Box(modifier = Modifier.height(IntrinsicSize.Max)) {
        DropDownInputField(
            currentSelection = user.graduationYear,
            onShowDropDown = viewModel::showGraduationYearDD,
            hint = "Graduation Year"
        )
        Box(modifier = Modifier
            .align(Alignment.CenterEnd)
            .fillMaxHeight()) {
            DropdownMenu(
                modifier = Modifier
                    .defaultMinSize(minWidth = 180.dp)
                    .heightIn(max = 500.dp)
                    .background(color = SPrimary50),
                expanded = viewModel.isGraduationYearDDVisible.value,
                onDismissRequest = viewModel::hideGraduationYearDD
            ) {
                viewModel.graduationYearList.forEach { item ->
                    DropdownMenuItem(
                        modifier = Modifier.fillMaxWidth(),
                        text = { Text(text = item) },
                        onClick = {
                            viewModel.hideGraduationYearDD()
                            viewModel.updateGraduationYear(item)
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun DepartmentDropDown(viewModel: RegisterScreenViewmodel) {
    val user by viewModel.user.collectAsState()
    Box(modifier = Modifier.height(IntrinsicSize.Max)) {
        DropDownInputField(
            currentSelection = user.branch,
            onShowDropDown = viewModel::showDepartmentDD,
            hint = "Branch/Department"
        )
        Box(modifier = Modifier
            .align(Alignment.CenterEnd)
            .fillMaxHeight()) {
            DropdownMenu(
                modifier = Modifier
                    .defaultMinSize(minWidth = 200.dp)
                    .heightIn(max = 500.dp)
                    .background(color = SPrimary50),
                expanded = viewModel.isDepartmentDDVisible.value,
                onDismissRequest = viewModel::hideDepartmentDD
            ) {
                viewModel.departmentList.forEach { item ->
                    DropdownMenuItem(
                        modifier = Modifier.fillMaxWidth(),
                        text = { Text(text = item) },
                        onClick = {
                            viewModel.hideDepartmentDD()
                            viewModel.updateBranch(item)
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun CollegeDropDown(viewModel: RegisterScreenViewmodel) {
    val user by viewModel.user.collectAsState()
    Box(modifier = Modifier.height(IntrinsicSize.Max)) {
        DropDownInputField(
            currentSelection = user.college,
            onShowDropDown = viewModel::showCollegeDD,
            hint = "College"
        )
        Box(modifier = Modifier
            .align(Alignment.CenterEnd)
            .fillMaxHeight()) {
            DropdownMenu(
                modifier = Modifier
                    .defaultMinSize(minWidth = 200.dp)
                    .heightIn(max = 500.dp)
                    .background(color = SPrimary50),
                expanded = viewModel.isCollegeDDVisible.value,
                onDismissRequest = viewModel::hideCollegeDD
            ) {
                viewModel.collegeList.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            viewModel.hideCollegeDD()
                            viewModel.updateCollege(item)
                        }
                    )
                }
            }
        }

    }
}