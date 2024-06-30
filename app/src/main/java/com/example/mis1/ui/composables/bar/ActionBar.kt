package com.example.mis1.ui.composables.bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.R
import com.example.mis1.ui.theme.Primary01
import com.example.mis1.ui.theme.White

@Preview
@Composable
fun ActionBar() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = White)
                .height(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .weight(1f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "MIS",
                    fontSize = 16.sp,
                    lineHeight = 18.sp,
                    fontWeight = FontWeight(500),
                    color = Primary01,
                )
                Image(
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp),
                    painter = painterResource(id = R.drawable.bell_pin),
                    contentDescription = "user",
                )
            }
            HorizontalDivider(color = Color(0x0D000000))
        }
}