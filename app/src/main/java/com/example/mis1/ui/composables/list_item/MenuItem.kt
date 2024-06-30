package com.example.mis1.ui.composables.list_item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.ui.theme.PageBgColor
import com.example.mis1.ui.theme.Primary10
import com.example.mis1.ui.theme.RoundedRectangleL
import com.example.mis1.ui.theme.SPrimarySource

@Composable
fun MenuItem(text: String, painter: Painter, onClick:()->Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(94.dp)
            .clip(RoundedRectangleL)
            .background(color = PageBgColor)
            .border(width = 1.dp, color = Primary10, shape = RoundedRectangleL)
            .clickable(onClick =onClick)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val height = 24.dp
        Text(text = text,
            fontSize = 16.sp,
            lineHeight = 18.sp,
            color = SPrimarySource
        )
        Image(
            modifier = Modifier
                .height(height)
                .width(height), painter = painter, contentDescription = null
        )
    }
}