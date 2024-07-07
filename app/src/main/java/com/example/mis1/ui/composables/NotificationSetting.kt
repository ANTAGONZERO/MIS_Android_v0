package com.example.mis1.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.common.Settings
import com.example.mis1.ui.composables.button.Toggle
import com.example.mis1.ui.composables.list_item.SettingItem
import com.example.mis1.ui.theme.Primary02
import com.example.mis1.viewmodels.SettingsScreenViewmodel

@Composable
fun NotificationSetting(viewModel:SettingsScreenViewmodel){
    val settings by viewModel.settings.collectAsState()
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = "Alerts:",
        fontSize = 24.sp,
        fontWeight = FontWeight(500),
        color = Primary02,
        textDecoration = TextDecoration.Underline
    )
    Spacer(modifier = Modifier.height(12.dp))
    SettingItem(name = "Email", checked = settings[Settings.EMAIL] == "true") {
        viewModel.toggleSetting(Settings.EMAIL)
    }
    Spacer(modifier = Modifier.height(8.dp))
    SettingItem(name = "Desktop", checked = settings[Settings.DESKTOP] == "true") {
        viewModel.toggleSetting(Settings.DESKTOP)
    }
    Spacer(modifier = Modifier.height(8.dp))
    SettingItem(name = "Mobile", checked = settings[Settings.MOBILE] == "true") {
        viewModel.toggleSetting(Settings.MOBILE)
    }
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
    SettingItem(name = "Booking Confirmation", checked = settings[Settings.BOOKING_CONFIRMATION] == "true") {
        viewModel.toggleSetting(Settings.BOOKING_CONFIRMATION)
    }
    Spacer(modifier = Modifier.height(8.dp))
    SettingItem(name = "Equipment Availability", checked = settings[Settings.EQUIPMENT_AVAILABILITY] == "true") {
        viewModel.toggleSetting(Settings.EQUIPMENT_AVAILABILITY)
    }
    Spacer(modifier = Modifier.height(8.dp))
    SettingItem(name = "Workshop Reminders", checked = settings[Settings.WORKSHOP_REMINDERS] == "true") {
        viewModel.toggleSetting(Settings.WORKSHOP_REMINDERS)
    }
    Spacer(modifier = Modifier.height(8.dp))
    SettingItem(name = "Upcoming events", checked = settings[Settings.UPCOMING_EVENTS] == "true") {
        viewModel.toggleSetting(Settings.UPCOMING_EVENTS)
    }
    Spacer(modifier = Modifier.height(8.dp))
    SettingItem(name = "In-app messages", checked = settings[Settings.IN_APP_MESSAGES] == "true") {
        viewModel.toggleSetting(Settings.IN_APP_MESSAGES)
    }

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
        Toggle(checked = settings[Settings.Sound]=="true"){
            viewModel.toggleSetting(Settings.Sound)
        }
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
        Toggle(checked = settings[Settings.Banner] == "true"){
            viewModel.toggleSetting(Settings.Banner)
        }
    }
}