package com.example.mis1.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mis1.R
import com.example.mis1.ui.composables.MenuItem
import com.example.mis1.ui.routes.Screens
import com.example.mis1.ui.theme.Accent00
import com.example.mis1.ui.theme.Size120
import com.example.mis1.ui.theme.White

@Preview
@Composable
fun MenuScreen(
    navController: NavController = rememberNavController()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 16.dp)
            .background(color = White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            val itemSeparation = Size120
            Spacer(modifier = Modifier.height(itemSeparation))
            MenuItem(
                text = "DASHBOARD",
                painter = painterResource(id = R.drawable.dashboard_alt),
                onClick = {
                    navController.navigate(Screens.Home.path)
                }
            )
            Spacer(modifier = Modifier.height(itemSeparation))
            MenuItem(
                text = "EXPLORE INVENTORY",
                painter = painterResource(id = R.drawable.globe),
                onClick = {
                    navController.navigate(Screens.Inventory.path)
                }
            )
            Spacer(modifier = Modifier.height(itemSeparation))
            MenuItem(
                text = "TRAINING",
                painter = painterResource(id = R.drawable.training),
                onClick = {
                    navController.navigate(Screens.Training.path)
                }
            )
            Spacer(modifier = Modifier.height(itemSeparation))
            MenuItem(
                text = "PROJECTS",
                painter = painterResource(id = R.drawable.dashboard_alt),
                onClick = {
                    navController.navigate(Screens.Project.path)
                }
            )
            Spacer(modifier = Modifier.height(itemSeparation))
            MenuItem(
                text = "RECORDS",
                painter = painterResource(id = R.drawable.dashboard_alt),
                onClick = {
                    navController.navigate(Screens.Record.path)
                }
            )
        }
        Image(
            modifier = Modifier
                .height(32.dp)
                .width(149.dp),
            painter = painterResource(id = R.drawable.powered_by),
            contentDescription = "powered by MapIT.ai",
        )
    }
}