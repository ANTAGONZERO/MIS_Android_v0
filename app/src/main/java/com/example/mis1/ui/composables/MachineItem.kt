package com.example.mis1.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.R
import com.example.mis1.data.remote.machine.dto.Machine
import com.example.mis1.ui.theme.Primary01
import com.example.mis1.ui.theme.Primary09
import com.example.mis1.ui.theme.RoundedRectangleM
import com.example.mis1.ui.theme.RoundedRectangleS
import com.example.mis1.ui.theme.S
import com.example.mis1.ui.theme.SPrimarySource
import com.example.mis1.ui.theme.Size120
import com.example.mis1.ui.theme.Size80
import com.example.mis1.ui.theme.SizeNone

val sampleMachine = Machine(
    availability = "Low",
    availability1 = "1",
    category = "Tools",
    description = "heavy-duty hammer",
    id = 2,
    image = null,
    instances = 5,
    location = "Aisle 5",
    manufacturer = "BuildIt",
    name = "Hammer",
    purchaseCost = null,
    status = "Under Maintenance",
    status1 = "1",
    supervised = true,
    upc = "987654321098"
)

@Preview(widthDp = 312)
@Composable
fun MachineItem(
    machine: Machine = sampleMachine
) {
    val separation = S
    Column(
        modifier = Modifier
            .background(color = Color.White, shape = RoundedRectangleM)
            .border(width = SizeNone, color = Primary09, shape = RoundedRectangleM)
            .fillMaxWidth()
            .padding(start = Size120, top = Size80, end = Size120, bottom = Size80)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = machine.name,
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
            text = "Category: " + machine.category,
            fontSize = 14.sp,
            fontWeight = FontWeight(400),
            color = Primary01,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(separation))
        Row (verticalAlignment = Alignment.Bottom){
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Location: " + machine.location,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = Primary01,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(separation))
                Text(
                    text = "Description: " + machine.description,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = Primary01,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Spacer(modifier = Modifier.width(S))
            Column(
                modifier = Modifier
                    .border(width = SizeNone, color = SPrimarySource, shape = RoundedRectangleS)
                    .defaultMinSize(minHeight = 35.dp)
                    .padding(start = Size120, top = Size80, end = Size120, bottom = Size80),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Book Machine",
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF273F77),
                    maxLines = 1,
                )
            }
        }

    }
}