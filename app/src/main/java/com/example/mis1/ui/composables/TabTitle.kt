package com.example.mis1.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.R
import com.example.mis1.ui.composables.enums.TabTitleType
import com.example.mis1.ui.theme.Primary01
import com.example.mis1.ui.theme.Primary03
import com.example.mis1.ui.theme.RoundedRectangleS
import com.example.mis1.ui.theme.SAccent50
import com.example.mis1.ui.theme.SAccent500
import com.example.mis1.ui.theme.SAccentSource
import com.example.mis1.ui.theme.SPrimarySource
import com.example.mis1.ui.theme.Size120
import com.example.mis1.ui.theme.Size20
import com.example.mis1.ui.theme.Size40
import com.example.mis1.ui.theme.SizeNone


@Preview
@Composable
fun TabTitle(
    type: TabTitleType = TabTitleType.Inventory,
    text: String = "Title",
    isActive: Boolean = false,
    iconId:Int = R.drawable.bell_pin,
    onClick: () -> Unit = {}
) {
    when (type) {
        TabTitleType.Record -> Column(
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

        TabTitleType.Inventory -> {
            val activeModifier = Modifier
                .clip(RoundedRectangleS)
                .clickable(onClick = onClick)
                .border(width = 1.dp, color = SPrimarySource, shape = RoundedRectangleS)
                .padding(horizontal = Size120, vertical = Size40)

            val inactiveModifier = Modifier
                .clip(RoundedRectangleS)
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

        TabTitleType.Setting ->{
            val color1  = if(isActive) SAccent500 else Primary03
            val color2  = if(isActive) SAccent50 else Color.Transparent
            val color3  =  if(isActive) SAccent500 else Color.Transparent
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(width = SizeNone, color = color3, shape = RoundedRectangleS)
                    .clip(shape = RoundedRectangleS)
                    .background(color = color2)
                    .clickable (onClick = onClick)
                    .padding(start = Size120, top = 8.dp, end = Size120, bottom = 8.dp)
                ,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Icon(
                    modifier = Modifier.height(20.dp).width(20.dp),
                    painter = painterResource(id = iconId),
                    contentDescription = null,
                    tint = color1
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = text,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    color = color1
                )
            }
        }
    }

}