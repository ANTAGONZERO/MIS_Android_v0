package com.example.mis1.ui.composables.list_item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.R
import com.example.mis1.model.IssuedInventory
import com.example.mis1.ui.composables.Property
import com.example.mis1.ui.theme.M
import com.example.mis1.ui.theme.Primary01
import com.example.mis1.ui.theme.Primary09
import com.example.mis1.ui.theme.Primary11
import com.example.mis1.ui.theme.RoundedRectangleM
import com.example.mis1.ui.theme.Size40
import com.example.mis1.ui.theme.Size80
import com.example.mis1.ui.theme.SizeNone
import com.example.mis1.ui.theme.White

val sampleIssuedInventory = IssuedInventory(
    createdAt = "2024-06-19T11:22:43.319137+05:30",
    id = 1,
    inventory = sampleInventory,
    issuedBy = 1,
    issuedFrom = "2024-04-27",
    issuedTill = "2024-04-29",
    lastUpdatedAt = "2024-06-19T11:22:43.319173+05:30",
    pickup = "Yes",
    pickupOn = null,
    quantity = 3,
    returnDescription = null,
    returned = "No",
    returnedOn = null
)

@Preview(widthDp = 312)
@Composable
fun IssuableItem(issuedInventory: IssuedInventory = sampleIssuedInventory) {
    Column(
        modifier = Modifier
            .background(color = White, shape = RoundedRectangleM)
            .clipToBounds()
            .border(width = SizeNone, color = Primary09, shape = RoundedRectangleM)


    ) {
        Column(
            modifier = Modifier.padding(start = Size80, top = Size40, end = Size80, bottom = Size40)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .defaultMinSize(minHeight = 27.dp),
                    text = issuedInventory.inventory.name,
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
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "Description: ${issuedInventory.inventory.description?:""}",
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                color = Primary01,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        HorizontalDivider()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
                .background(
                    color = Primary11,
                    shape = RoundedCornerShape(bottomStart = M, bottomEnd = M)
                ),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Property(name = "Category", value = issuedInventory.inventory.category)
            VerticalDivider()
            Property(name = "Date", value = issuedInventory.lastUpdatedAt.substring(0, 10))
            VerticalDivider()

            Property(
                name = "Quantity",
                value = issuedInventory.quantity.toString()
            )
        }
    }
}