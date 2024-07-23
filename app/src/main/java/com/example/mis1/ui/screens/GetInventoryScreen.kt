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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mis1.R
import com.example.mis1.ui.composables.BorderBox
import com.example.mis1.ui.composables.button.AddButton
import com.example.mis1.ui.composables.button.CancelButton
import com.example.mis1.ui.composables.edit_field.EditDateField
import com.example.mis1.ui.theme.Primary02
import com.example.mis1.ui.theme.Primary03
import com.example.mis1.ui.theme.Size120
import com.example.mis1.viewmodels.PurchaseInventoryViewmodel

@Preview(widthDp = 312, showBackground = true)
@Composable
fun GetInventoryScreen(viewModel: PurchaseInventoryViewmodel = hiltViewModel()) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image1(id = R.drawable.user_add)
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    modifier = Modifier.padding(vertical = Size120, horizontal = 16.dp),
                    text = "Anjali Jain",
                    fontSize = 24.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(400),
                    color = Primary02
                )
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
                        hint = "Enter Quantity"
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image1(id = R.drawable.award_line)
                Spacer(modifier = Modifier.width(16.dp))
                BorderBox {
                    TextField1(
                        value = viewModel.unit.value,
                        onValueChanged = viewModel::setUnit,
                        hint = "Select the unit"
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image1(id = R.drawable.award_line)
                Spacer(modifier = Modifier.width(16.dp))
                BorderBox {
                    TextField1(
                        value = viewModel.typeOfProject.value,
                        onValueChanged = viewModel::setTypeOfProject,
                        hint = "Type of Project"
                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image1(id = R.drawable.edit)
                Spacer(modifier = Modifier.width(16.dp))
                BorderBox {
                    TextField1(
                        modifier = Modifier.fillMaxWidth(),
                        value = viewModel.projectTitle.value,
                        onValueChanged = viewModel::setProjectTitle,
                        hint = "Add Project Title"
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
                        modifier = Modifier
                            .height(68.dp)
                            .fillMaxWidth(),
                        value = viewModel.projectDescription.value,
                        onValueChanged = viewModel::setProjectDescription,
                        hint = "Add Project details"
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
                    AddButton(text = "Purchase", onClick = {})
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
    value: String,
    onValueChanged: (value: String) -> Unit,
    hint: String? = null
) {
    Box {
        if (hint != null && value.isEmpty()) {
            Text1(
                modifier = modifier,
                text = hint
            )
        }
        BasicTextField(
            modifier = modifier,
            value = value, onValueChange = onValueChanged,
            textStyle = TextStyle(
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(400),
                color = Primary03,
            )
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
private fun DateRangePicker(viewModel: PurchaseInventoryViewmodel) {
    Row (verticalAlignment = Alignment.CenterVertically){
        EditDateField(date = viewModel.startDate.value, onDateChange = viewModel::setStartDate)
        Text(modifier = Modifier.padding(8.dp),text = "To")
        EditDateField(date = viewModel.endDate.value, onDateChange = viewModel::setEndDate)
    }
}
