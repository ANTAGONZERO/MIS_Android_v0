package com.example.mis1.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.R
import com.example.mis1.data.remote.equipment.dto.Equipment
import com.example.mis1.ui.theme.InputFieldBorderColor
import com.example.mis1.ui.theme.PageBgColor
import com.example.mis1.ui.theme.Primary01
import com.example.mis1.ui.theme.RoundedRectangleL
import com.example.mis1.ui.theme.RoundedRectangleS
import com.example.mis1.ui.theme.S
import com.example.mis1.ui.theme.SPrimarySource
import com.example.mis1.ui.theme.Size120
import com.example.mis1.ui.theme.Size200
import com.example.mis1.ui.theme.Size400
import com.example.mis1.ui.theme.Size480
import com.example.mis1.ui.theme.Size80
import com.example.mis1.ui.theme.SizeNone
import com.example.mis1.ui.theme.White

val sampleEquipment = Equipment(
    category = "Furniture",
    createdAt = "2024-06-03T20:29:23.469953+05:30",
    description = "wooden desk",
    id = 2,
    image = null,
    instances = 5,
    lastUpdatedAt = "2024-06-03T20:29:23.469966+05:30",
    location = "Office B",
    manufacturer = "Ikea",
    name = "Desk",
    purchaseCost = "150.00",
    purchaseDate = null,
    status = "Operational",
    upc = "987654321098",
    warrantyExpiration = null
)


@Preview(widthDp = 312)
@Composable
fun EquipmentItem(equipment: Equipment = sampleEquipment) {
    Column(
        modifier = Modifier
            .background(color = White, shape = RoundedRectangleL)
            .border(width = SizeNone, color = InputFieldBorderColor, shape = RoundedRectangleL)
            .padding(start = Size120, top = Size200, end = Size120, bottom = Size200)
    ) {
        val separation = S
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = equipment.name,
                fontSize = 20.sp,
                fontWeight = FontWeight(500),
                color = Primary01,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Image(
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp),
                painter = painterResource(id = R.drawable.more_vertical_circle),
                contentDescription = "more"
            )
        }
        Spacer(modifier = Modifier.height(separation))
        Text(
            text = "Category: " + equipment.category,
            fontSize = 14.sp,
            fontWeight = FontWeight(400),
            color = Primary01,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(separation))

        Text(
            text = "Location: " + equipment.location,
            fontSize = 14.sp,
            fontWeight = FontWeight(400),
            color = Primary01,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(separation))
        Text(
            text = "Description: " + equipment.description,
            fontSize = 14.sp,
            fontWeight = FontWeight(400),
            color = Primary01,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(separation))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .background(color = PageBgColor, shape = RoundedRectangleS)
                    .border(width = SizeNone, color = SPrimarySource, shape = RoundedRectangleS)
                    .height(38.dp)
                    .width(137.dp)
                    .padding(horizontal = Size120, vertical = Size80),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "View",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    color = SPrimarySource,
                    maxLines = 1,
                )
            }

            Column(
                modifier = Modifier
                    .background(color = PageBgColor, shape = RoundedRectangleS)
                    .border(width = SizeNone, color = SPrimarySource, shape = RoundedRectangleS)
                    .width(Size480)
                    .height(Size400)
                    .padding(horizontal = Size120, vertical = Size80),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp),
                    painter = painterResource(id = R.drawable.favorite), contentDescription = "fav"
                )
            }
        }
    }
}
