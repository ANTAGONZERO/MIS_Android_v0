package com.example.mis1.ui.screens.inventory

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import com.example.mis1.data.remote.inventory.dto.Inventory
import com.example.mis1.ui.composables.BorderBox
import com.example.mis1.ui.composables.button.AddButton
import com.example.mis1.ui.composables.button.CancelButton
import com.example.mis1.ui.composables.edit_field.EditDateField
import com.example.mis1.ui.theme.Primary02
import com.example.mis1.ui.theme.Primary03
import com.example.mis1.ui.theme.Size120
import com.example.mis1.viewmodels.AppViewmodel
import com.example.mis1.viewmodels.inventory.IssueInventoryViewmodel


@Composable
fun IssueInventoryScreen(
    viewModel: IssueInventoryViewmodel = hiltViewModel(),
    appViewModel: AppViewmodel,
    navController: NavController,
    inventory: Inventory
) {

    LaunchedEffect(key1 = appViewModel.user) {
        appViewModel.user?.let { user -> viewModel.setUserId(user.id) }
    }

    LaunchedEffect(key1 =inventory) {
        viewModel.setInventory(inventory)
    }
    LaunchedEffect(key1 = viewModel.issueStatus) {
        if (viewModel.issueStatus is Resource.Success) {
            navController.popBackStack()
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image1(id = R.drawable.user_add)
                Spacer(modifier = Modifier.width(16.dp))
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
            Spacer(modifier = Modifier.height(24.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image1(id = R.drawable.calendar)
                Spacer(modifier = Modifier.width(16.dp))
                DateRangePicker(viewModel)
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image1(id = R.drawable.quantity_limits)
                Spacer(modifier = Modifier.width(16.dp))
                BorderBox {
                    TextField1(
                        value = viewModel.quantity.value,
                        onValueChanged = viewModel::setQuantity,
                        hint = "Enter Quantity",
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
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

            Spacer(modifier = Modifier.height(20.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image1(id = R.drawable.award_line)
                Spacer(modifier = Modifier.width(16.dp))
                BorderBox {
                    TextField1(
                        enabled = false,
                        value = viewModel.typeOfProject.value,
                        onValueChanged = {},
                        hint = "Type of Project"
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
            Row {
                Box(modifier = Modifier.padding(top = Size120)) {
                    Image1(id = R.drawable.note_text_plus_line)
                }
                Spacer(modifier = Modifier.width(16.dp))
                BorderBox {
                    TextField1(
                        enabled = false,
                        modifier = Modifier
                            .height(68.dp)
                            .fillMaxWidth(),
                        value = viewModel.projectDescription.value,
                        onValueChanged = {},
                        hint = "Project details"
                    )
                }
            }
        }
        Column {
            Row {
                Box(modifier = Modifier.weight(1f)) {
                    CancelButton(onClick = {
                        navController.popBackStack()
                    })
                }
                Spacer(modifier = Modifier.width(16.dp))
                Box(modifier = Modifier.weight(1f)) {
                    AddButton(text = "Issue", onClick = viewModel::issue)
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
private fun Text1(modifier: Modifier = Modifier, text: String) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight(400),
        color = Primary03,
    )
}

@Composable
private fun TextField1(
    modifier: Modifier = Modifier,
    enabled:Boolean = true,
    value: String,
    onValueChanged: (value: String) -> Unit,
    hint: String? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    Box {
        if (hint != null && value.isEmpty()) {
            Text1(
                modifier = modifier,
                text = hint
            )
        }
        BasicTextField(
            enabled = enabled ,
            modifier = modifier,
            value = value, onValueChange = onValueChanged,
            textStyle = TextStyle(
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(400),
                color = Primary03,

                ),
            keyboardOptions = keyboardOptions
        )
    }
}

@Composable
private fun Image1(id: Int) {
    Image(
        modifier = Modifier
            .width(20.dp)
            .height(20.dp),
        painter = painterResource(id = id),
        contentDescription = "icon"
    )
}

@Composable
private fun DateRangePicker(viewModel: IssueInventoryViewmodel) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        EditDateField(date = viewModel.startDate.value, onDateChange = viewModel::setStartDate)
        Text(modifier = Modifier.padding(8.dp), text = "To")
        EditDateField(date = viewModel.endDate.value, onDateChange = viewModel::setEndDate)
    }
}
