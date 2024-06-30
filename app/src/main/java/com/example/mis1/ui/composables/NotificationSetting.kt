package com.example.mis1.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.ui.composables.button.Toggle
import com.example.mis1.ui.composables.list_item.SettingItem
import com.example.mis1.ui.theme.Primary02

@Composable
fun NotificationSetting(){
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = "Alerts:",
        fontSize = 24.sp,
        fontWeight = FontWeight(500),
        color = Primary02,
        textDecoration = TextDecoration.Underline
    )
    Spacer(modifier = Modifier.height(12.dp))
    SettingItem(name = "Email")
    Spacer(modifier = Modifier.height(8.dp))
    SettingItem(name = "Desktop")
    Spacer(modifier = Modifier.height(8.dp))
    SettingItem(name = "Mobile")
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = "Allow Alerts for:",
        fontSize = 24.sp,
        fontWeight = FontWeight(500),
        color = Primary02,
        textDecoration = TextDecoration.Underline
    )
    Spacer(modifier = Modifier.height(12.dp))
    SettingItem(name = "Booking Confirmation")
    Spacer(modifier = Modifier.height(8.dp))
    SettingItem(name = "Equipment Availability")
    Spacer(modifier = Modifier.height(8.dp))
    SettingItem(name = "Workshop Reminders")
    Spacer(modifier = Modifier.height(8.dp))
    SettingItem(name = "Upcoming events")
    Spacer(modifier = Modifier.height(8.dp))
    SettingItem(name = "In-app messages")
    Spacer(modifier = Modifier.height(16.dp))
    Row (modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = "Sound",
            fontSize = 24.sp,
            fontWeight = FontWeight(500),
            color = Primary02,
            textDecoration = TextDecoration.Underline
        )
        Toggle(checked = false)
    }
    Spacer(modifier = Modifier.height(16.dp))
    Row (modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = "Banner",
            fontSize = 24.sp,
            fontWeight = FontWeight(500),
            color = Primary02,
            textDecoration = TextDecoration.Underline
        )
        Toggle(checked = false)
    }
}