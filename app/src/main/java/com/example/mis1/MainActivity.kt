package com.example.mis1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mis1.ui.App
import com.example.mis1.ui.composables.ActionBar
import com.example.mis1.ui.composables.NavigationBar
import com.example.mis1.ui.composables.SearchBar
import com.example.mis1.ui.screens.InventoryScreen
import com.example.mis1.ui.screens.MenuScreen
import com.example.mis1.ui.theme.Mis1Theme
import com.example.mis1.ui.theme.White
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mis1Theme {
                // A surface container using the 'background' color from the theme
                App()
            }
        }
    }
}