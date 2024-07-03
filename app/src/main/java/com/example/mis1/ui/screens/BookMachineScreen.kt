package com.example.mis1.ui.screens

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mis1.R
import com.example.mis1.ui.composables.BorderBox
import com.example.mis1.ui.composables.button.AddButton
import com.example.mis1.ui.composables.button.CancelButton
import com.example.mis1.ui.composables.edit_field.EditDateField
import com.example.mis1.ui.composables.edit_field.EditTimeField
import com.example.mis1.ui.composables.edit_field.NumberInputField
import com.example.mis1.ui.theme.Primary02
import com.example.mis1.ui.theme.Primary03
import com.example.mis1.ui.theme.Size120
import com.example.mis1.viewmodels.BookMachineViewmodel


@Composable
fun BookMachineScreen(
    viewModel: BookMachineViewmodel = hiltViewModel()
) {
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
                Text(
                    modifier = Modifier.padding(vertical = Size120, horizontal = 16.dp),
                    text = "Anjali jain",
                    fontSize = 24.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(400),
                    color = Primary02
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image1(id = R.drawable.calendar)
                Spacer(modifier = Modifier.width(14.dp))
                EditDateField(date = viewModel.date.value, onDateChange = viewModel::updateDate)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image1(id = R.drawable.time)
                Spacer(modifier = Modifier.width(14.dp))
                BorderBox {
                    NumberInputField(
                        hours = viewModel.hours.value,
                        onValueChange = viewModel::updateHours,
                        hint = "Enter the no. of hours"
                    )
                }
            }
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
                BorderBox {
                    Text1(text = "Type of Project")
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
                        onValueChange = viewModel::updateProjectTitle,
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
                        onValueChange = viewModel::updateProjectDetails,
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
                    CancelButton(onClick = {})
                }
                Spacer(modifier = Modifier.width(16.dp))
                Box(modifier = Modifier.weight(1f)) {
                    AddButton(text = "Book", onClick = {})
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