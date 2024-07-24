package com.example.mis1.ui.composables.list_item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
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
import com.example.mis1.data.remote.inventory.dto.Inventory
import com.example.mis1.ui.composables.Tag
import com.example.mis1.ui.theme.Accent00
import com.example.mis1.ui.theme.Accent08
import com.example.mis1.ui.theme.ActionLightSuccess
import com.example.mis1.ui.theme.ActionSuccess
import com.example.mis1.ui.theme.InputFieldBorderColor
import com.example.mis1.ui.theme.PageBgColor
import com.example.mis1.ui.theme.Primary01
import com.example.mis1.ui.theme.Primary09
import com.example.mis1.ui.theme.RoundedRectangleL
import com.example.mis1.ui.theme.RoundedRectangleS
import com.example.mis1.ui.theme.S
import com.example.mis1.ui.theme.SAccent50
import com.example.mis1.ui.theme.SAccentSource
import com.example.mis1.ui.theme.SPrimary50
import com.example.mis1.ui.theme.SPrimarySource
import com.example.mis1.ui.theme.Size120
import com.example.mis1.ui.theme.Size200
import com.example.mis1.ui.theme.Size400
import com.example.mis1.ui.theme.Size480
import com.example.mis1.ui.theme.Size80
import com.example.mis1.ui.theme.SizeNone
import com.example.mis1.ui.theme.White

val sampleInventory = Inventory(
    category = "Electronics",
    createdAt = "2024-06-03T20:58:51.404340+05:30",
    description = "Lightweight laptop with high-end specifications and modern design.",
    group = "Gadgets",
    id = 5,
    image = null,
    isHidden = false,
    lastUpdatedAt = "2024-06-03T21:01:15.593739+05:30",
    location = "WH.105",
    manufacturer = "CompTech",
    name = "Z500",
    purchaseCost = 899.99f,
    purchaseDate = "2024-03-15",
    stockAvailable = 75,
    stockTotal = 100,
    stockUnit = "pieces",
    tag1 = "Cutting",
    tag2 = "Stock",
    tag3 = "Free",
    tag4 = "In-lab-only",
    upc = "456789032425",
    warrantyExpiration = "2026-03-15"
)

@OptIn(ExperimentalLayoutApi::class)
@Preview(widthDp = 312)
@Composable
fun InventoryItem(inventory: Inventory = sampleInventory,onShow :()->Unit ={},onClickGet:()->Unit={}) {

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
                text = inventory.name,
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
        FlowRow(
            modifier = Modifier,
            maxItemsInEachRow = 2,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            if (!inventory.tag1.isNullOrBlank()) {
                Column {
                    Row {
                        Tag(
                            text = inventory.tag1,
                            color = SPrimarySource,
                            backgroundColor = SPrimary50
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
            if (!inventory.tag2.isNullOrBlank()) {
                Column {
                    Row {
                        Tag(
                            text = inventory.tag2,
                            color = SAccentSource,
                            backgroundColor = SAccent50
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
            if (!inventory.tag3.isNullOrBlank()) {
                Column {
                    Row {
                        Tag(text = inventory.tag3, color = Accent00, backgroundColor = Accent08)
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
            if (!inventory.tag4.isNullOrBlank()) {
                Column {
                    Tag(
                        text = inventory.tag4,
                        color = ActionSuccess,
                        backgroundColor = ActionLightSuccess
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val tags = listOf(inventory.tag1,inventory.tag2,inventory.tag3,inventory.tag4)
            if(tags.contains("Purchase") || tags.contains("Issue"))
                Column(
                    modifier = Modifier
                        .background(color = PageBgColor, shape = RoundedRectangleS)
                        .clickable { onClickGet() }
                        .border(width = SizeNone, color = SAccentSource, shape = RoundedRectangleS)
                        .height(38.dp)
                        .width(137.dp)
                        .padding(horizontal = Size120, vertical = Size80),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Get",
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        color = SAccentSource,
                        maxLines = 1,
                    )
                }
            else
                Column(
                    modifier = Modifier
                        .background(color = PageBgColor, shape = RoundedRectangleS)
                        .border(width = SizeNone, shape = RoundedRectangleS,color = Primary09)
                        .height(38.dp)
                        .width(137.dp)
                        .padding(horizontal = Size120, vertical = Size80),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Free to Use",
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        color = SAccentSource,
                        maxLines = 1,
                    )
                }

            Row {
                Column(
                    modifier = Modifier
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
                        painter = painterResource(id = R.drawable.favorite),
                        contentDescription = "fav"
                    )
                }
                Column(
                    modifier = Modifier
                        .width(Size480)
                        .height(Size400)
                        .padding(horizontal = Size120, vertical = Size80),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier
                            .height(24.dp)
                            .width(24.dp)
                            .clickable(onClick = onShow),
                        painter = painterResource(id = R.drawable.eye),
                        contentDescription = "eye"
                    )
                }
            }
        }
    }
}