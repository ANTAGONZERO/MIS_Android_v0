package com.example.mis1.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.ui.composables.EditButton
import com.example.mis1.ui.composables.Property
import com.example.mis1.ui.composables.enums.PropertyType
import com.example.mis1.ui.theme.Accent00
import com.example.mis1.ui.theme.Primary04
import com.example.mis1.ui.theme.Primary08
import com.example.mis1.ui.theme.RoundedRectangleM
import com.example.mis1.ui.theme.RoundedRectangleS
import com.example.mis1.ui.theme.SAccentSource
import com.example.mis1.ui.theme.SPrimarySource
import com.example.mis1.ui.theme.Size120
import com.example.mis1.ui.theme.Size80
import com.example.mis1.ui.theme.SizeNone

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true, widthDp = 312)
@Composable
fun ProfileScreen() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())){
        Spacer(modifier = Modifier.height(Size120))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(width = SizeNone, color = Primary08, shape = RoundedRectangleM)
                .padding(Size80)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = "My Profile",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    color = SPrimarySource
                )
                EditButton()
            }
            Spacer(modifier = Modifier.height(Size120))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .border(width = 1.2.dp, color = SAccentSource, shape = RoundedRectangleS)
                        .background(Color.Blue,shape = RoundedRectangleS)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Ron Wisely",
                        fontSize = 16.sp,
                        lineHeight = 18.sp,
                        fontWeight = FontWeight(500),
                        color = SPrimarySource,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Student",
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        fontWeight = FontWeight(400),
                        color = Primary04
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(width = SizeNone, color = Primary08, shape = RoundedRectangleM)
                .padding(Size80)

        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Personal Information",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    color = SPrimarySource
                )
                Spacer(modifier = Modifier.weight(1f))
                EditButton()
            }
            Spacer(modifier = Modifier.height(Size120))
            Property(
                name = "First Name",
                value = "Ron",
                type = PropertyType.Medium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Property(
                name = "Last Name",
                value = "Wisely",
                type = PropertyType.Medium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Property(
                name = "Email Address",
                value = "ron.wisely@iit.gmail.com",
                type = PropertyType.Medium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Property(
                name = "Phone no.",
                value = "02548617500",
                type = PropertyType.Medium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Property(
                    name = "Password",
                    value = "*********",
                    type = PropertyType.Medium
                )
                TextButton(onClick = { }) {
                    Text(
                        text = "Change password",
                        fontSize = 16.sp,
                        fontWeight = FontWeight(400),
                        color = Accent00,
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(width = SizeNone, color = Primary08, shape = RoundedRectangleM)
                .padding(Size80)

        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "College Information",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    color = SPrimarySource
                )
                Spacer(modifier = Modifier.weight(1f))
                EditButton()
            }
            Spacer(modifier = Modifier.height(Size120))
            Property(
                name = "Branch",
                value = "Mechanical",
                type = PropertyType.Medium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Property(
                name = "Graduation Year",
                value = "2021-2024",
                type = PropertyType.Medium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Property(
                name = "Graduation Year",
                value = "2021-2024",
                type = PropertyType.Medium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Property(
                name = "Graduation Year",
                value = "2021-2024",
                type = PropertyType.Medium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Property(
                name = "Graduation Year",
                value = "2021-2024",
                type = PropertyType.Medium
            )
        }
    }
}
