package com.example.mis1.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mis1.ui.theme.Primary01
import com.example.mis1.ui.theme.RoundedRectangleS
import com.example.mis1.ui.theme.Size120
import com.example.mis1.ui.theme.White

@Composable
fun BorderBox(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .border(width = 1.dp, color = Primary01, shape = RoundedRectangleS)
            .background(color = White, shape = RoundedRectangleS)
            .padding(horizontal = 16.dp, vertical = Size120)
    ) {
        content()
    }
}
