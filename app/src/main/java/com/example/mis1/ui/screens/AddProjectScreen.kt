package com.example.mis1.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mis1.R
import com.example.mis1.common.ProjectProgressStatus
import com.example.mis1.common.ProjectType
import com.example.mis1.common.Resource
import com.example.mis1.ui.composables.button.AddButton
import com.example.mis1.ui.composables.button.CancelButton
import com.example.mis1.ui.theme.Primary02
import com.example.mis1.ui.theme.Primary03
import com.example.mis1.ui.theme.Primary09
import com.example.mis1.ui.theme.RoundedRectangleS
import com.example.mis1.ui.theme.Size120
import com.example.mis1.viewmodels.AddProjectViewmodel
import com.example.mis1.viewmodels.AppViewmodel


@Composable
fun AddProjectScreen(viewModel: AddProjectViewmodel = hiltViewModel(), appViewModel: AppViewmodel , navController: NavController) {
    LaunchedEffect(key1 = viewModel.addStatus) {
        if(viewModel.addStatus is Resource.Success){
            navController.popBackStack()
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
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

//            Row(verticalAlignment = Alignment.CenterVertically) {
//                Image1(id = R.drawable.user_identifier_card)
//                Spacer(modifier = Modifier.width(16.dp))
//                Container {
//                    TextField1(
//                        value = viewModel.studentID.value,
//                        onValueChanged = viewModel::setStudentID,
//                        hint = "Student Id"
//                    )
//                }
//            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image1(id = R.drawable.file_plus_line)
                Spacer(modifier = Modifier.width(16.dp))
                Container {
                    Text1(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(onClick = { viewModel.showProjectTypeDD() }),
                        text = if (viewModel.typeOfProject.value == null) "Type of project"
                        else viewModel.typeOfProject.value!!.displayName
                    )
                }
                Box{
                    DropdownMenu(
                        expanded = viewModel.isProjectTypeDDVisible,
                        onDismissRequest = viewModel::hideProjectTypeDD
                    ) {
                        ProjectType.entries.forEach { projectType ->
                            DropdownMenuItem(
                                text = { Text1(text = projectType.displayName) },
                                onClick = { viewModel.setTypeOfProject(projectType)
                                    viewModel.hideProjectTypeDD()
                                })
                        }
                    }
                }
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image1(id = R.drawable.progress)
                Spacer(modifier = Modifier.width(16.dp))
                Container {
                    Text1(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(onClick = { viewModel.showProgressStatusDD() }),
                        text = if (viewModel.projectProgressStatus.value == null) "Project progress status"
                        else viewModel.projectProgressStatus.value!!.displayName
                    )
                }
                Box{
                    DropdownMenu(
                        expanded = viewModel.isProgressStatusDDVisible,
                        onDismissRequest = viewModel::hideProgressStatusDD
                    ) {
                        ProjectProgressStatus.entries.forEach { progressStatus ->
                            DropdownMenuItem(
                                text = { Text1(text = progressStatus.displayName) },
                                onClick = { viewModel.setProjectProgressStatus(progressStatus)
                                    viewModel.hideProgressStatusDD()
                                })
                        }
                    }
                }
            }
//            Row(verticalAlignment = Alignment.CenterVertically) {
//                Image1(id = R.drawable.group_add_light)
//                Spacer(modifier = Modifier.width(16.dp))
//                Container {
//                    TextField1(
//                        value = viewModel.teammates.value,
//                        onValueChanged = viewModel::setTeammates, hint = "Add Teammates"
//                    )
//                }
//            }
//            Row(verticalAlignment = Alignment.CenterVertically) {
//                Image1(id = R.drawable.link)
//                Spacer(modifier = Modifier.width(16.dp))
//                Container {
//                    TextField1(
//                        value = viewModel.linksOrDocuments.value,
//                        onValueChanged = viewModel::setLinksOrDocuments,
//                        hint = "Add links/documents"
//                    )
//                }
//            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image1(id = R.drawable.edit)
                Spacer(modifier = Modifier.width(16.dp))
                Container {
                    TextField1(
                        modifier = Modifier.fillMaxWidth(),
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
                        modifier = Modifier
                            .height(68.dp)
                            .fillMaxWidth(),
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
                    CancelButton(onClick = {
                        navController.popBackStack()
//                        navController.navigate(Screens.AddProject.path){
//                            popUpTo(Screens.AddProject.path){
//                                inclusive = false
//                            }
//                            launchSingleTop = true
//                        }
                    })
                }
                Spacer(modifier = Modifier.width(16.dp))
                Box(modifier = Modifier.weight(1f)) {
                    AddButton(text = "Add", onClick = {
                        appViewModel.user?.let { viewModel.addProject(it.id) }
                    })
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