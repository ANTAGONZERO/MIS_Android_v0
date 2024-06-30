package com.example.mis1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mis1.ui.App
import com.example.mis1.ui.theme.Mis1Theme
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