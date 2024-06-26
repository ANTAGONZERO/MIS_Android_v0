package com.example.mis1.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mis1.R
import com.example.mis1.ui.composables.NotificationSetting
import com.example.mis1.ui.composables.PrivacySetting
import com.example.mis1.ui.composables.TabTitle
import com.example.mis1.ui.composables.enums.TabTitleType
import com.example.mis1.ui.routes.SettingTabs
import com.example.mis1.viewmodels.SettingsScreenViewmodel

@Composable
fun SettingScreen(
    viewmodel: SettingsScreenViewmodel = hiltViewModel()
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
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
            NotificationSetting()
        else
            PrivacySetting()
    }
}