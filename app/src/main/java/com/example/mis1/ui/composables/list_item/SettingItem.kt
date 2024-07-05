package com.example.mis1.ui.composables.list_item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.mis1.ui.composables.button.Toggle
import com.example.mis1.ui.composables.enums.SettingItemType
import com.example.mis1.ui.theme.Primary02
import com.example.mis1.ui.theme.Primary04

@Preview(showBackground = true)
@Composable
fun SettingItem(
    type: SettingItemType = SettingItemType.A,
    name: String = "Email",
    description: String = "description",
    checked:Boolean = false,
    onToggle: () -> Unit = {}
) {
    when (type) {
        SettingItemType.A -> Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = name,
                fontSize = 20.sp,
                fontWeight = FontWeight(400),
                color = Primary02,
            )
            Toggle(checked = checked, onToggle = onToggle)
        }

        SettingItemType.B -> Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight(500),
                    color = Primary02,
                )
                Text(
                    text = "Allow others to view your bookings/issues",
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = Primary04
                )
            }
            Toggle(checked = checked,onToggle = onToggle)
        }
    }

}