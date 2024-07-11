package com.example.mis1.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.ui.theme.Primary01
import com.example.mis1.ui.theme.SPrimary50
import com.example.mis1.ui.theme.Size40

@Preview
@Composable
fun UserRoleToggle(isStudent:Boolean = true,onToggle: () -> Unit ={}) {
    val studentColor = if (isStudent) Color.White else Color.Transparent
    val adminColor = if (isStudent) Color.Transparent else Color.White

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
            .clip(CircleShape)
            .background(color = SPrimary50)
            .padding(Size40)

    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .clip(CircleShape)
                .background(studentColor)
                .clickable(onClick = onToggle)
                .padding(vertical = 4.dp, horizontal = 4.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Student",
                color = Primary01,
                fontSize = 16.sp,
                fontWeight = FontWeight(400)
            )
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .clip(CircleShape)
                .background(adminColor)
                .clickable(onClick = onToggle)
                .padding(vertical = 4.dp, horizontal = 4.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Admin",
                color = Primary01,
                fontSize = 16.sp,
                fontWeight = FontWeight(400)
            )
        }
    }
}