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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.ui.composables.enums.SettingItemType
import com.example.mis1.ui.composables.list_item.SettingItem
import com.example.mis1.ui.theme.ActionError
import com.example.mis1.ui.theme.RoundedRectangleS
import com.example.mis1.ui.theme.White

@Preview(widthDp = 312, showBackground = true)
@Composable
fun PrivacySetting(){
    Column (modifier = Modifier.fillMaxWidth()){
        SettingItem(type=SettingItemType.B, name = "Discoverability", description = "Allow others to view your bookings/issues")
        Spacer(modifier = Modifier.height(32.dp))
        SettingItem(type=SettingItemType.B, name = "Visibility", description = "Allow others to view your bookings/issues")
        Spacer(modifier = Modifier.height(32.dp))
        SettingItem(type=SettingItemType.B, name = "Location", description = "Allow others to view your bookings/issues")
        Spacer(modifier = Modifier.height(32.dp))
        SettingItem(type=SettingItemType.B, name = "Your booking and issues", description = "Allow others to view your bookings/issues")
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