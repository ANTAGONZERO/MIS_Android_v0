package com.example.mis1.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mis1.ui.composables.bar.ActionBar
import com.example.mis1.ui.composables.bar.NavigationBar
import com.example.mis1.ui.routes.Screens

@Composable
fun ProtectedScreens(navController: NavHostController = rememberNavController()){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ActionBar()
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(0.9f)
        ) {
            NavHost(
                navController = navController,
                startDestination = Screens.Menu.path
            ) {
                composable(Screens.Menu.path) {
                    MenuScreen(navController = navController)
                }
                composable(Screens.Home.path) {
                    HomeScreen()
                }
                composable(Screens.Chat.path) {
                    ChatScreen()
                }
                composable(Screens.Setting.path) {
                    SettingScreen()
                }
                composable(Screens.Profile.path) {
                    ProfileScreen()
                }
                composable(Screens.Inventory.path) {
                    InventoryScreen(navController = navController)
                }
                composable(Screens.Training.path) {
                    TrainingScreen()
                }
                composable(Screens.Project.path) {
                    ProjectScreen()
                }
                composable(Screens.Record.path) {
                    RecordScreen()
                }
                composable(Screens.BookMachine.path) {
                    BookMachineScreen()
                }
            }
        }
        NavigationBar(navController = navController)
    }
}