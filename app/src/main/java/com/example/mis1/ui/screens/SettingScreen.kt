package com.example.mis1.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mis1.R
import com.example.mis1.model.Settings
import com.example.mis1.ui.composables.button.TabTitle
import com.example.mis1.ui.composables.button.Toggle
import com.example.mis1.ui.composables.enums.SettingItemType
import com.example.mis1.ui.composables.enums.TabTitleType
import com.example.mis1.ui.composables.list_item.SettingItem
import com.example.mis1.ui.routes.SettingTabs
import com.example.mis1.ui.theme.ActionError
import com.example.mis1.ui.theme.Primary02
import com.example.mis1.ui.theme.RoundedRectangleS
import com.example.mis1.ui.theme.White
import com.example.mis1.viewmodels.SettingsScreenViewmodel

@Composable
fun SettingScreen(
    viewmodel: SettingsScreenViewmodel = hiltViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Max)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Box(modifier = Modifier.weight(1f)) {
                TabTitle(
                    type = TabTitleType.Setting,
                    text = "Notification",
                    isActive = viewmodel.visibleTab.value == SettingTabs.Notification,
                    iconId = R.drawable.bell_pin,
                    onClick = {
                        viewmodel.showNotificationTab()
                    }
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            VerticalDivider(Modifier.fillMaxHeight(0.7f))
            Spacer(modifier = Modifier.width(8.dp))
            Box(modifier = Modifier.weight(1f)) {
                TabTitle(
                    type = TabTitleType.Setting,
                    text = "Privacy",
                    isActive = viewmodel.visibleTab.value == SettingTabs.Privacy,
                    iconId = R.drawable.privacy,
                    onClick = {
                        viewmodel.showPrivacyTab()
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        if (viewmodel.visibleTab.value == SettingTabs.Notification)
            NotificationSetting(viewmodel)
        else
            PrivacySetting(viewmodel)
    }
}

@Composable
private fun NotificationSetting(viewModel:SettingsScreenViewmodel){
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


@Composable
private fun PrivacySetting(viewModel:SettingsScreenViewmodel){
    val settings by viewModel.settings.collectAsState()
    Column (modifier = Modifier.fillMaxWidth()){
        SettingItem(type = SettingItemType.B, name = "Discoverability", description = "Allow others to view your bookings/issues", checked = settings[Settings.DISCOVERABILITY] == "true") {
            viewModel.toggleSetting(Settings.DISCOVERABILITY)
        }
        Spacer(modifier = Modifier.height(32.dp))
        SettingItem(type = SettingItemType.B, name = "Visibility", description = "Allow others to view your bookings/issues", checked = settings[Settings.VISIBILITY] == "true") {
            viewModel.toggleSetting(Settings.VISIBILITY)
        }
        Spacer(modifier = Modifier.height(32.dp))
        SettingItem(type = SettingItemType.B, name = "Location", description = "Allow others to view your bookings/issues", checked = settings[Settings.LOCATION] == "true") {
            viewModel.toggleSetting(Settings.LOCATION)
        }
        Spacer(modifier = Modifier.height(32.dp))
        SettingItem(type = SettingItemType.B, name = "Your booking and issues", description = "Allow others to view your bookings/issues", checked = settings[Settings.YOUR_BOOKING_AND_ISSUES] == "true") {
            viewModel.toggleSetting(Settings.YOUR_BOOKING_AND_ISSUES)
        }
        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier
                .width(158.dp)
                .height(38.dp)
                .background(
                    color = ActionError,
                    shape = RoundedRectangleS
                )
            ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = "Delete Account",
                fontSize = 16.sp,
                fontWeight = FontWeight(500),
                color = White
            )
        }
    }
}