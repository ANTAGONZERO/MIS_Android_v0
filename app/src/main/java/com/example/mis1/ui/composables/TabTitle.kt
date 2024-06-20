package com.example.mis1.ui.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.ui.composables.enums.TabTitleType
import com.example.mis1.ui.theme.Primary01
import com.example.mis1.ui.theme.Primary03
import com.example.mis1.ui.theme.RoundedRectangleS
import com.example.mis1.ui.theme.SAccentSource
import com.example.mis1.ui.theme.SPrimarySource
import com.example.mis1.ui.theme.Size120
import com.example.mis1.ui.theme.Size20
import com.example.mis1.ui.theme.Size40


@Preview
@Composable
fun TabTitle(
    type: TabTitleType = TabTitleType.SurroundedActive,
    text: String = "Title",
    isActive: Boolean = false,
    onClick: () -> Unit = {}
) {
    when (type) {
        TabTitleType.BottomActive -> Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column {
                Text(
                    text = text,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    color = if (isActive) Primary01 else Primary03
                )
            }
            HorizontalDivider(
                thickness = Size20,
                color = if (isActive) SAccentSource else Color.Transparent
            )
        }

        TabTitleType.SurroundedActive -> {
            val activeModifier = Modifier
                .clickable(onClick = onClick)
                .border(width = 1.dp, color = SPrimarySource, shape = RoundedRectangleS)
                .padding(horizontal = Size120, vertical = Size40)

            val inactiveModifier = Modifier
                .clickable(onClick = onClick)
                .padding(horizontal = Size120, vertical = Size40)

            Box(
                modifier = (if (isActive) activeModifier else inactiveModifier)
            ) {
                Text(
                    text = text,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    color = if (isActive) SPrimarySource else Primary01
                )
            }
        }
    }

}