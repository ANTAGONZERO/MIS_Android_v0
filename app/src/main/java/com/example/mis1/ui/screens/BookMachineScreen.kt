package com.example.mis1.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mis1.R
import com.example.mis1.common.Resource
import com.example.mis1.ui.composables.BorderBox
import com.example.mis1.ui.composables.button.AddButton
import com.example.mis1.ui.composables.button.CancelButton
import com.example.mis1.ui.composables.edit_field.EditDateField
import com.example.mis1.ui.composables.edit_field.EditTimeField
import com.example.mis1.ui.theme.Primary02
import com.example.mis1.ui.theme.Primary03
import com.example.mis1.ui.theme.Size120
import com.example.mis1.viewmodels.AppViewmodel
import com.example.mis1.viewmodels.BookMachineViewmodel


@Composable
fun BookMachineScreen(
    viewModel: BookMachineViewmodel = hiltViewModel(),
    machineId: Int,
    appViewModel: AppViewmodel,
    navController: NavController
) {
    LaunchedEffect(key1 = machineId) {
        viewModel.updateMachine(machineId)
    }
    LaunchedEffect(key1 = appViewModel.user) {
        appViewModel.user?.let { user -> viewModel.updateReservedBy(user.id) }
    }
    LaunchedEffect(key1 = viewModel.reservationStatus) {
        if (viewModel.reservationStatus.value is Resource.Success) {
            navController.popBackStack()
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image1(id = R.drawable.user_add)
                Spacer(modifier = Modifier.width(14.dp))
                appViewModel.user?.let {
                    Text(
                        modifier = Modifier.padding(vertical = Size120, horizontal = 16.dp),
                        text = it.username,
                        fontSize = 24.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(400),
                        color = Primary02
                    )
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image1(id = R.drawable.calendar)
                Spacer(modifier = Modifier.width(14.dp))
                EditDateField(date = viewModel.date.value, onDateChange = viewModel::updateDate)
            }
//            Row(verticalAlignment = Alignment.CenterVertically) {
//                Image1(id = R.drawable.time)
//                Spacer(modifier = Modifier.width(14.dp))
//                BorderBox {
//                    HourInputField(
//                        hours = viewModel.hours.value,
//                        onValueChange = viewModel::updateHours,
//                    )
//                }
//            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image1(id = R.drawable.time)
                Spacer(modifier = Modifier.width(14.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    EditTimeField(time = viewModel.startTime.value, viewModel::updateStartTime)
                    Text(
                        text = "To",
                        modifier = Modifier.padding(8.dp)
                    )
                    EditTimeField(time = viewModel.endTime.value, viewModel::updateEndTime)
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image1(id = R.drawable.award_line)
                Spacer(modifier = Modifier.width(14.dp))
                var expanded by remember { mutableStateOf(false) }
                Box(modifier = Modifier.clickable { expanded = !expanded }) {
                    BorderBox {
                        Text1(text = viewModel.project.value?.title ?: "Select Project")
                    }
                    DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                        viewModel.projectList.forEach { project ->
                            DropdownMenuItem(
                                text = { Text1(text = project.title) },
                                onClick = {
                                    viewModel.updateProject(project)
                                    expanded = false
                                })
                        }
                    }
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image1(id = R.drawable.edit)
                Spacer(modifier = Modifier.width(14.dp))
                BorderBox {
                    if (viewModel.projectTitle.value.isEmpty()) {
                        Text1(text = "Add Project Title")
                    }
                    BasicTextField(
                        value = viewModel.projectTitle.value,
                        onValueChange = {},
                        textStyle = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight(400),
                            color = Primary03
                        ),
                        maxLines = 1
                    )
                }
            }
            Row {
                Image1(id = R.drawable.note_text_plus_line)
                Spacer(modifier = Modifier.width(14.dp))
                BorderBox {
                    if (viewModel.projectDetails.value.isEmpty()) {
                        Text1(text = "Add Project Details")
                    }
                    BasicTextField(
                        value = viewModel.projectDetails.value,
                        onValueChange = {},
                        textStyle = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight(400),
                            color = Primary03
                        ),
                        modifier = Modifier
                            .height(100.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }
        Column {
            Row {
                Box(modifier = Modifier.weight(1f)) {
                    CancelButton(onClick = navController::popBackStack)
                }
                Spacer(modifier = Modifier.width(16.dp))
                Box(modifier = Modifier.weight(1f)) {
                    AddButton(text = "Book", onClick = viewModel::bookMachine)
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
private fun Image1(id: Int) {
    Image(
        modifier = Modifier
            .width(24.dp)
            .height(Size120 + 24.dp)
            .padding(top = Size120),
        painter = painterResource(id = id),
        contentDescription = "icon"
    )
}

@Composable
private fun Text1(text: String) {
    Text(
        text = text,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight(400),
        color = Primary03,
    )
}


@Composable
private fun HourInputField(
    hours: String,
    onValueChange: (String) -> Unit,

    ) {
    val hint = "Enter the no. of hours"
    Box(modifier = Modifier.width(IntrinsicSize.Max)) {
        if (hours.isEmpty()) {
            Text(
                text = hint,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(400),
                    color = Primary03
                )
            )
        }
        BasicTextField(
            value = hours,
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            textStyle = TextStyle(
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(400),
                color = Primary03
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}