package com.example.mis1.ui.composables.button

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.ui.theme.RoundedRectangleS
import com.example.mis1.ui.theme.SAccent700
import com.example.mis1.ui.theme.SAccentSource
import com.example.mis1.ui.theme.SizeNone
import com.example.mis1.ui.theme.White

@Composable
@Preview
fun EnrollButton() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedRectangleS)
            .border(shape = RoundedRectangleS, color = SAccent700, width = SizeNone)
            .background(color = SAccentSource)
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Enrol Now",
            fontSize = 20.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight(500),
            color = White
        )
    }
}