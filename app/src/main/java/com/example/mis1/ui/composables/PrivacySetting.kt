package com.example.mis1.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.common.Settings
import com.example.mis1.ui.composables.enums.SettingItemType
import com.example.mis1.ui.composables.list_item.SettingItem
import com.example.mis1.ui.theme.ActionError
import com.example.mis1.ui.theme.RoundedRectangleS
import com.example.mis1.ui.theme.White
import com.example.mis1.viewmodels.SettingsScreenViewmodel

@Composable
fun PrivacySetting(viewModel:SettingsScreenViewmodel){
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