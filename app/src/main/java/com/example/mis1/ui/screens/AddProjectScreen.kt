package com.example.mis1.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mis1.R
import com.example.mis1.ui.composables.button.AddButton
import com.example.mis1.ui.composables.button.CancelButton
import com.example.mis1.ui.theme.Primary02
import com.example.mis1.ui.theme.Primary03
import com.example.mis1.ui.theme.Primary09
import com.example.mis1.ui.theme.RoundedRectangleS
import com.example.mis1.ui.theme.Size120
import com.example.mis1.viewmodels.AddProjectViewmodel


@Preview()
@Composable
fun AddProjectScreen(viewModel: AddProjectViewmodel = hiltViewModel()) {
    Column(verticalArrangement = Arrangement.SpaceBetween) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image1(id = R.drawable.user_add)
                Spacer(modifier = Modifier.width(16.dp))
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
                Image1(id = R.drawable.user_identifier_card)
                Spacer(modifier = Modifier.width(16.dp))
                Container {
                    TextField1(
                        value = viewModel.studentID.value,
                        onValueChanged = viewModel::setStudentID,
                        hint = "Student Id"
                    )
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image1(id = R.drawable.file_plus_line)
                Spacer(modifier = Modifier.width(16.dp))
                Container {
                    TextField1(
                        value = viewModel.typeOfProject.value,
                        onValueChanged = viewModel::setTypeOfProject, hint = "Type Of Project"
                    )
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image1(id = R.drawable.progress)
                Spacer(modifier = Modifier.width(16.dp))
                Container {
                    TextField1(
                        value = viewModel.projectProgressStatus.value,
                        onValueChanged = viewModel::setProjectProgressStatus,
                        hint = "Project progress status"
                    )
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image1(id = R.drawable.group_add_light)
                Spacer(modifier = Modifier.width(16.dp))
                Container {
                    TextField1(
                        value = viewModel.teammates.value,
                        onValueChanged = viewModel::setTeammates, hint = "Add Teammates"
                    )
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image1(id = R.drawable.link)
                Spacer(modifier = Modifier.width(16.dp))
                Container {
                    TextField1(
                        value = viewModel.linksOrDocuments.value,
                        onValueChanged = viewModel::setLinksOrDocuments,
                        hint = "Add links/documents"
                    )
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image1(id = R.drawable.edit)
                Spacer(modifier = Modifier.width(16.dp))
                Container {
                    TextField1(
                        value = viewModel.projectTitle.value,
                        onValueChanged = viewModel::setProjectTitle,
                        hint = "Add project title"
                    )
                }
            }
            Row {
                Box(modifier = Modifier.padding(top = Size120)) {
                    Image1(id = R.drawable.note_text_plus_line)
                }
                Spacer(modifier = Modifier.width(16.dp))
                Container {
                    TextField1(
                        modifier = Modifier.height(68.dp),
                        value = viewModel.projectDescription.value,
                        onValueChanged = viewModel::setProjectDescription,
                        hint = "Add project description"
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
                    AddButton(text = "Add", onClick = {})
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
private fun Container(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = Primary09, shape = RoundedRectangleS)
            .background(color = Color(0xFFF8F8F8), shape = RoundedRectangleS)
            .padding(horizontal = 16.dp, vertical = Size120)
    ) {
        content()
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
        contentDescription = "me"
    )
}