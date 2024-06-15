package com.example.mis1.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.ui.theme.CircularEdge
import com.example.mis1.ui.theme.SPrimary50
import com.example.mis1.ui.theme.SPrimarySource
import com.example.mis1.ui.theme.Size20

@Preview(backgroundColor = 0xFFFFFFFF)
@Composable
fun Tag(text:String = "Cutting", color:Color = SPrimarySource, backgroundColor:Color =  SPrimary50){
    Row (modifier = Modifier
        .height(22.dp)
        .background(color = backgroundColor, shape = CircularEdge)
        .padding(start = 8.dp, top = Size20, end = 8.dp, bottom = Size20),
        verticalAlignment = Alignment.CenterVertically){
            Text(
                text = text,
                color = color,
                fontSize = 14.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight(400),
            )
    }
}