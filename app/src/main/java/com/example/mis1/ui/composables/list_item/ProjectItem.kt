package com.example.mis1.ui.composables.list_item

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.R
import com.example.mis1.ui.composables.Tag
import com.example.mis1.ui.theme.ActionLightSuccess
import com.example.mis1.ui.theme.ActionSuccess
import com.example.mis1.ui.theme.Primary01
import com.example.mis1.ui.theme.Primary03
import com.example.mis1.ui.theme.Primary07
import com.example.mis1.ui.theme.RoundedRectangleL
import com.example.mis1.ui.theme.SAccentSource
import com.example.mis1.ui.theme.SPrimary100
import com.example.mis1.ui.theme.Size140
import com.example.mis1.ui.theme.SizeNone

@Preview(widthDp = 312, showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun ProjectItem(){
    Column(modifier = Modifier

        .fillMaxWidth()

        .border(width = SizeNone, color = SPrimary100, shape = RoundedRectangleL)
        .padding(Size140)

    ) {
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Tag(text = " • Completed " ,color = ActionSuccess, backgroundColor = ActionLightSuccess)
            Image(
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp),
                painter = painterResource(id = R.drawable.meatballs_menu),
                contentDescription = "more"
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Drone",
            fontSize = 24.sp,
            fontWeight = FontWeight(700),
            color = SAccentSource
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Description",
            fontSize = 14.sp,
            lineHeight = 21.sp,
            fontWeight = FontWeight(500),
            color = Primary01,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "We are making an ai based drone",
            fontSize = 14.sp,
            lineHeight = 21.sp,
            fontWeight = FontWeight(500),
            color = Primary03
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Text(text = "Type :",
                fontSize = 14.sp,
                lineHeight = 21.sp,
                fontWeight = FontWeight(500),
                color = Primary01
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Club Project",
                fontSize = 14.sp,
                lineHeight = 21.sp,
                fontWeight = FontWeight(500),
                color = Primary03)
        }
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "12/12/23",
            fontSize = 14.sp,
            lineHeight = 21.sp,
            fontWeight = FontWeight(500),
            color = Primary07)

    }
}