package com.example.mis1.ui.composables.bar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mis1.R
import com.example.mis1.ui.routes.Screens
import com.example.mis1.ui.theme.Primary01
import com.example.mis1.ui.theme.SAccentSource
import com.example.mis1.ui.theme.Size180
import com.example.mis1.ui.theme.Size480
import com.example.mis1.ui.theme.White

@Composable
@Preview
fun NavigationBar(navController: NavController = rememberNavController()) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = White)
            .height(48.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp)
                    .clickable { navController.navigate(Screens.Home.path){
                        popUpTo(Screens.Menu.path) { inclusive = false }
                        launchSingleTop = true
                    } },
                painter = painterResource(id = R.drawable.home),
                contentDescription = "home",
                tint = if (currentRoute == Screens.Home.path) SAccentSource else Primary01
            )
            Icon(
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp)
                    .clickable { navController.navigate(Screens.Chat.path){
                        popUpTo(Screens.Menu.path) { inclusive = false }
                        launchSingleTop = true
                    } },
                painter = painterResource(id = R.drawable.chat_alt_3),
                contentDescription = "chat",
                tint = if (currentRoute == Screens.Chat.path) SAccentSource else Primary01
            )
            Icon(
                modifier = Modifier
                    .width(Size480)
                    .height(Size180)
                    .clickable { navController.navigate(Screens.Menu.path){
                        popUpTo(0) { inclusive = true }
                        launchSingleTop = true
                    } },
                painter = painterResource(id = R.drawable.menu),
                contentDescription = "menu",
                tint = if (currentRoute == Screens.Menu.path) SAccentSource else Primary01
            )
            Icon(
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp)
                    .clickable { navController.navigate(Screens.Setting.path){
                        popUpTo(Screens.Menu.path) { inclusive = false }
                        launchSingleTop = true
                    } },
                painter = painterResource(id = R.drawable.setting_alt_line),
                contentDescription = "setting",
                tint = if (currentRoute == Screens.Setting.path) SAccentSource else Primary01
            )
            Icon(
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp)
                    .clickable { navController.navigate(Screens.Profile.path){
                        popUpTo(Screens.Menu.path) { inclusive = false }
                        launchSingleTop = true
                    } },
                painter = painterResource(id = R.drawable.user_cicrle),
                contentDescription = "user",
                tint = if (currentRoute == Screens.Profile.path) SAccentSource else Primary01
            )
        }
    }
}