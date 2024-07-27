package com.example.mis1.ui.screens.training

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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mis1.R
import com.example.mis1.common.toTwoDigitString
import com.example.mis1.ui.composables.Filters
import com.example.mis1.ui.composables.bar.SearchBar
import com.example.mis1.ui.composables.button.TabTitle
import com.example.mis1.ui.composables.enums.TabTitleType
import com.example.mis1.ui.composables.list_item.TutorialItem
import com.example.mis1.ui.composables.list_item.WorkshopItem
import com.example.mis1.ui.composables.modal.WorkshopDetail
import com.example.mis1.ui.routes.TrainingTabs
import com.example.mis1.ui.theme.Primary02
import com.example.mis1.ui.theme.Primary03
import com.example.mis1.ui.theme.RoundedRectangleM
import com.example.mis1.ui.theme.RoundedTopRectangleXXXL
import com.example.mis1.ui.theme.SPrimary50
import com.example.mis1.ui.theme.Size120
import com.example.mis1.ui.theme.SizeNone
import com.example.mis1.ui.theme.White
import com.example.mis1.viewmodels.AppViewmodel
import com.example.mis1.viewmodels.training.TrainingViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrainingScreen(
    viewModel: TrainingViewModel = hiltViewModel(),
    appViewModel: AppViewmodel
) {
    LaunchedEffect(key1 = appViewModel.user) {
        appViewModel.user?.let { viewModel.updateUser(it) }
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(Size120))
        Row {
            SearchBar(modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(8.dp))
            Filters()
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier.weight(1f)) {
                TabTitle(type = TabTitleType.Training,
                    text = "Tutorials",
                    isActive = viewModel.visibleTab == TrainingTabs.TUTORIALS,
                    onClick = {
                        viewModel.goto(TrainingTabs.TUTORIALS)
                    })
            }
            Box(modifier = Modifier.weight(1f)) {
                TabTitle(type = TabTitleType.Training,
                    text = "Workshop",
                    isActive = viewModel.visibleTab == TrainingTabs.WORKSHOPS,
                    onClick = {
                        viewModel.goto(TrainingTabs.WORKSHOPS)
                    })
            }
            Box(modifier = Modifier.weight(1f)) {
                TabTitle(type = TabTitleType.Training,
                    text = "My Learning",
                    isActive = viewModel.visibleTab == TrainingTabs.MY_LEARNING,
                    onClick = {
                        viewModel.goto(TrainingTabs.MY_LEARNING)
                    })
            }

        }

        Spacer(modifier = Modifier.height(Size120))
        when (viewModel.visibleTab) {
            TrainingTabs.TUTORIALS -> Tutorials(viewModel)
            TrainingTabs.WORKSHOPS -> Workshops(viewModel)
            TrainingTabs.MY_LEARNING -> MyLearning(viewModel)
        }

        val scope = rememberCoroutineScope()
        val sheetState = rememberModalBottomSheetState()
        val onHide = {
            scope.launch {
                sheetState.hide()
                viewModel.hideWorkshopDetail()
            }
        }

        if (viewModel.workshopDetailVisible)
            ModalBottomSheet(
                onDismissRequest = viewModel::hideWorkshopDetail,
                dragHandle = { Box {} },
                shape = RoundedTopRectangleXXXL,
                sheetState = sheetState,
                containerColor = White
            ) {
                WorkshopDetail(
                    workshop = viewModel.workshops[viewModel.workshopDetailIndex],
                    onHide = {onHide()}
                )
            }
    }
}

@Composable
private fun Tutorials(viewModel: TrainingViewModel) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(Size120)) {
        items(viewModel.tutorials) { tutorial ->
            TutorialItem(tutorial = tutorial)
        }
    }
}

@Composable
private fun Workshops(viewModel: TrainingViewModel) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(Size120)) {
        itemsIndexed(viewModel.workshops) {index,item ->
            WorkshopItem(workshop = item, onClickView = {
                viewModel.showWorkshopDetailModal(index)
            })
        }
    }
}

@Composable
private fun MyLearning(viewModel: TrainingViewModel) {
    Column {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(Size120)) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedRectangleM)
                        .border(width = SizeNone, color = Primary02, shape = RoundedRectangleM)
                        .background(color = SPrimary50)
                        .clickable { }
                        .padding(vertical = 12.dp, horizontal = 24.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(id = R.drawable.left_to_right_list_bullet),
                        contentDescription = null
                    )
                    Text(
                        text = "Your Watchlist",
                        fontSize = 14.sp,
                        lineHeight = 19.sp,
                        fontWeight = FontWeight(500),
                        color = Primary03
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                StatusCardRow()
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Recent Enrolled Courses",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF5C5C5C),
                )
            }
            items(viewModel.tutorials) { tutorial ->
                TutorialItem(alreadyStarted = true, percentage = 45, tutorial = tutorial)
            }
        }
    }

}

@Composable
private fun StatusCardRow() {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        StatusCard(
            count = 4,
            label = "Course\nCompleted",
            backgroundColor = Color(0xFFF3FFF1),
            contentColor = Color(0xFF4E9B45),
            borderColor = Color(0xFF4E9B45)
        )
        StatusCard(
            count = 5,
            label = "Workshop\nCompleted",
            backgroundColor = Color(0xFFF6E7ED),
            contentColor = Color(0xFFED2E7D),
            borderColor = Color(0xFFED2E7D)
        )
        StatusCard(
            count = 2,
            label = "Course In\nProgress",
            backgroundColor = Color(0xFFE6F1FE),
            contentColor = Color(0xFF007BFF),
            borderColor = Color(0xFF007BFF)
        )

    }
}

@Composable
private fun StatusCard(
    count: Int,
    label: String,
    backgroundColor: Color,
    contentColor: Color,
    modifier: Modifier = Modifier,
    borderColor: Color,
) {
    Box(
        modifier = modifier
            .width(92.dp)
            .height(IntrinsicSize.Max)
            .background(color = backgroundColor, shape = RoundedRectangleM)
            .border(width = SizeNone, color = borderColor, shape = RoundedRectangleM)
            .padding(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = count.toTwoDigitString(),
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
                color = contentColor,
                letterSpacing = 0.1.sp,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = label,
                fontSize = 12.sp,
                fontWeight = FontWeight(500),
                color = contentColor,
                textAlign = TextAlign.Center,
                letterSpacing = 0.1.sp,
                lineHeight = 16.sp
            )
        }
    }
}