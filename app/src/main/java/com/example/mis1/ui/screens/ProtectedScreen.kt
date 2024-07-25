package com.example.mis1.ui.screens

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
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
import com.example.mis1.data.remote.inventory.dto.Inventory
import com.example.mis1.ui.composables.bar.ActionBar
import com.example.mis1.ui.composables.bar.NavigationBar
import com.example.mis1.ui.routes.Screens
import com.example.mis1.ui.screens.inventory.BookMachineScreen
import com.example.mis1.ui.screens.inventory.InventoryScreen
import com.example.mis1.ui.screens.inventory.IssueInventoryScreen
import com.example.mis1.ui.screens.inventory.PurchaseInventoryScreen
import com.example.mis1.ui.screens.project.AddProjectScreen
import com.example.mis1.ui.screens.project.ProjectScreen
import com.example.mis1.ui.screens.training.TrainingScreen
import com.example.mis1.viewmodels.AppViewmodel
import com.google.gson.Gson
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

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
                startDestination = Screens.Menu.path,
                enterTransition = { fadeIn(tween(150)) },
                exitTransition = { fadeOut(tween(150)) }
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
                    ProfileScreen(appViewModel = appViewModel)
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
                composable(route = Screens.IssueInventory.path +"/{inventory}",
                    arguments = listOf(navArgument("inventory") { type = NavType.StringType })
                ){
                    it.arguments?.getString("inventory")?.let { encodedJsonString ->
                        val gson = Gson()
                        val jsonString = URLDecoder.decode(encodedJsonString, StandardCharsets.UTF_8.toString())
                        val inventory = gson.fromJson(jsonString,Inventory::class.java)
                        IssueInventoryScreen(appViewModel = appViewModel, navController = navController, inventory = inventory)
                    }
                }

                composable(route = Screens.PurchaseInventory.path +"/{inventory}",
                    arguments = listOf(navArgument("inventory") { type = NavType.StringType })
                ){
                    it.arguments?.getString("inventory")?.let { encodedJsonString ->
                        val gson = Gson()
                        val jsonString = URLDecoder.decode(encodedJsonString, StandardCharsets.UTF_8.toString())
                        val inventory = gson.fromJson(jsonString,Inventory::class.java)
                        PurchaseInventoryScreen(appViewModel = appViewModel, navController = navController, inventory = inventory)
                    }
                }
            }
        }
        NavigationBar(navController = navController)
    }
}