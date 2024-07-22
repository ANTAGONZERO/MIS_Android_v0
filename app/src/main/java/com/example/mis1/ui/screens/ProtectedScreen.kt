package com.example.mis1.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mis1.ui.composables.bar.ActionBar
import com.example.mis1.ui.composables.bar.NavigationBar
import com.example.mis1.ui.routes.Screens
import com.example.mis1.viewmodels.AppViewmodel

@Composable
fun ProtectedScreens(
    navController: NavHostController = rememberNavController(),
    appViewModel: AppViewmodel
) {
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
                    ProjectScreen(appViewModel = appViewModel, navController = navController)
                }
                composable(Screens.Record.path) {
                    RecordScreen()
                }
                composable(
                    route = Screens.BookMachine.path + "/{machineId}",
                    arguments = listOf(navArgument("machineId") { type = NavType.IntType })
                ) {
                    it.arguments?.getInt("machineId")?.let { machineId ->
                        BookMachineScreen(
                            machineId = machineId,
                            navController = navController,
                            appViewModel = appViewModel
                        )
                    }
                }
                composable(Screens.AddProject.path){
                    AddProjectScreen(appViewModel = appViewModel, navController = navController)
                }
            }
        }
        NavigationBar(navController = navController)
    }
}