package com.example.mis1.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mis1.R
import com.example.mis1.ui.routes.Screens
import com.example.mis1.ui.theme.Primary01
import com.example.mis1.ui.theme.Primary09
import com.example.mis1.ui.theme.SAccentSource
import com.example.mis1.ui.theme.SPrimary100
import com.example.mis1.ui.theme.SPrimary500
import com.example.mis1.ui.theme.Size400
import com.example.mis1.ui.theme.SizeNone
import com.example.mis1.viewmodels.OnboardScreenViewmodel
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardScreen(navController:NavController,viewModel: OnboardScreenViewmodel = hiltViewModel()) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight()
        ) {
            TextButton(
                modifier = Modifier.align(Alignment.End),
                onClick = {
                    gotoWelcomeScreen(navController,viewModel)
                }) {
                Text(
                    text = "Skip",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    color = Primary01
                )
            }
            val pageCount = 3
            val state = rememberPagerState { pageCount }
            val scope = rememberCoroutineScope()
            HorizontalPager(
                modifier = Modifier.fillMaxHeight(0.77f),
                state = state
            ) { currentPage ->
                Page(pageNumber = currentPage)
            }
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                PageIndicator(pageNumber = state.currentPage, pageCount = pageCount)
            }
            Box(
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .border(width = SizeNone, color = SPrimary500, shape = CircleShape)
                    .height(Size400)
                    .width(Size400)
                    .align(Alignment.End)
                    .background(color = SPrimary100)
                    .clickable {
                        if (state.canScrollForward) {
                            scope.launch {
                                state.animateScrollToPage(
                                    state.currentPage + 1
                                )
                            }
                        } else {
                            gotoWelcomeScreen(navController, viewModel)
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp),
                    painter = painterResource(id = R.drawable.arrow_alt_lright),
                    contentDescription = "next"
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Image(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(149.dp)
                    .height(32.dp),
                painter = painterResource(id = R.drawable.powered_by),
                contentDescription = "powered by"
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
private fun Page(pageNumber: Int) {
    val images = listOf(
        R.drawable.onboarding1,
        R.drawable.onboarding2,
        R.drawable.onboarding3
    )
    val titles = listOf(
        "Welcome to \nthe Tinker’s \nLab",
        "Accessing \nInventory \nReports",
        "Support \nand \nAssistance"
    )

    val descriptions = listOf(
        "Ensuring our technology resources are well - managed and efficiently used.",
        "Generate detailed reports to track equipment usage and availability.",
        "Contact the support team for any questions or issues with the inventory system."
    )

    Column {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            painter = painterResource(id = images[pageNumber]),
            contentDescription = "onboarding"
        )
        Text(
            text = titles[pageNumber],
            fontSize = 48.sp,
            lineHeight = 60.sp,
            fontWeight = FontWeight(500),
            color = SAccentSource,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = descriptions[pageNumber],
            fontSize = 16.sp,
            fontWeight = FontWeight(400),
            color = Primary01,
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
private fun PageIndicator(pageNumber: Int, @Suppress("SameParameterValue") pageCount: Int) {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        repeat(pageCount) { index ->
            val color = if (index == pageNumber) Primary01 else Primary09
            Box(
                modifier = Modifier
                    .padding(1.dp)
                    .width(8.dp)
                    .height(8.dp)
                    .background(color = color, shape = CircleShape),
            )
        }
    }
}

private fun gotoWelcomeScreen(navController: NavController,viewModel: OnboardScreenViewmodel){
    viewModel.setClientOnboarded()
    navController.navigate(Screens.WelcomeScreen.path){
        popUpTo(Screens.OnBoardScreen.path){
            inclusive  = true
        }
    }
}