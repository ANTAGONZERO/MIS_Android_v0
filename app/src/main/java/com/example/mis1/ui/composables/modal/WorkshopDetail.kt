package com.example.mis1.ui.composables.modal

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.R
import com.example.mis1.data.remote.training.dto.Workshop
import com.example.mis1.ui.composables.button.EnrollButton
import com.example.mis1.ui.theme.RoundedTopRectangleXXXL
import com.example.mis1.ui.theme.SPrimary100
import com.example.mis1.ui.theme.Size120
import com.example.mis1.ui.theme.Size80
import com.example.mis1.ui.theme.SizeNone

@Composable
fun WorkshopDetail(workshop: Workshop, onHide: () -> Unit) {
    Box (modifier = Modifier.clip(RoundedTopRectangleXXXL).fillMaxWidth()
        .border(color = SPrimary100, width = SizeNone, shape = RoundedTopRectangleXXXL),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(Size120)
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "From:  ${workshop.fromDate}  ${workshop.fromTime.substring(0, 5)}\n" +
                        "To:  ${workshop.toDate}  ${workshop.toTime.substring(0, 5)}",
                fontSize = 12.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF12A594)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = workshop.title,
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF3F3F3F)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Description",
                fontSize = 14.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF3F3F3F),
            )
            Text(
                text = workshop.description,
                fontSize = 12.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF5C5C5C),
            )
            Spacer(modifier = Modifier.height(Size80))
            EnrollButton()
            Spacer(modifier = Modifier.height(60.dp))
        }
        Column(
            modifier = Modifier
                .width(60.dp)
                .height(60.dp)
                .align(Alignment.TopEnd),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .height(44.dp)
                    .width(44.dp)
                    .clickable(onClick = onHide),
                painter = painterResource(id = R.drawable.close),
                contentDescription = "close"
            )
        }
    }
}