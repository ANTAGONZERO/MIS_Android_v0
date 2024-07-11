package com.example.mis1.ui.composables.modal

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.R
import com.example.mis1.data.remote.inventory.dto.Inventory
import com.example.mis1.ui.composables.Property
import com.example.mis1.ui.composables.Tag
import com.example.mis1.ui.composables.enums.PropertyType
import com.example.mis1.ui.composables.list_item.sampleInventory
import com.example.mis1.ui.theme.Accent00
import com.example.mis1.ui.theme.Accent08
import com.example.mis1.ui.theme.ActionLightSuccess
import com.example.mis1.ui.theme.ActionSuccess
import com.example.mis1.ui.theme.PageBgColor
import com.example.mis1.ui.theme.RoundedTopRectangleXXL
import com.example.mis1.ui.theme.SAccent50
import com.example.mis1.ui.theme.SAccentSource
import com.example.mis1.ui.theme.SPrimary200
import com.example.mis1.ui.theme.SPrimary50
import com.example.mis1.ui.theme.SPrimary600
import com.example.mis1.ui.theme.SPrimarySource
import com.example.mis1.ui.theme.Size80
import com.example.mis1.ui.theme.SizeNone

@OptIn(ExperimentalLayoutApi::class)
@Preview
@Composable
fun InventoryDetail(inventory:Inventory = sampleInventory , onHide : ()->Unit = {}){
    Box(modifier = Modifier){
        Column (modifier = Modifier
            .border(color = SPrimary200, width = SizeNone, shape = RoundedTopRectangleXXL)
            .width(360.dp)
            .background(color = PageBgColor, shape = RoundedTopRectangleXXL)
            .padding(start = 24.dp, top = 16.dp, end = 24.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween){
            Text(
                text = inventory.name,
                fontSize = 24.sp,
                lineHeight = 36.sp,
                fontWeight = FontWeight(700),
                color = SPrimary600,
            )
            Spacer(modifier = Modifier.height(Size80))
            Property(type= PropertyType.HorizontalMedium,name = "Category",value = inventory.category)
            Spacer(modifier = Modifier.height(Size80))
            Property(type= PropertyType.HorizontalMedium,name = "Stock available",value = inventory.stockAvailable.toString())
            Spacer(modifier = Modifier.height(Size80))
            Property(type= PropertyType.HorizontalMedium,name = "Location",value = inventory.location?:"Unknown")
            Spacer(modifier = Modifier.height(Size80))
            Property(type= PropertyType.HorizontalMedium,name = "UPC",value = inventory.upc)
            Spacer(modifier = Modifier.height(Size80))
            Property(type= PropertyType.HorizontalMedium,name = "Manufacturer name",value = inventory.manufacturer?:"Unknown")
            Spacer(modifier = Modifier.height(Size80))
            Row {
                Property(type= PropertyType.HorizontalMedium,name = "Tag",value = "")
                FlowRow {
                    if (inventory.tag1 != null) {
                        Column {
                            Row {
                                Tag(
                                    text = inventory.tag1,
                                    color = SPrimarySource,
                                    backgroundColor = SPrimary50
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                            }
                            Spacer(modifier = Modifier.height(Size80))
                        }
                    }
                    if (inventory.tag2 != null) {
                        Column {
                            Row {
                                Tag(
                                    text = inventory.tag2,
                                    color = SAccentSource,
                                    backgroundColor = SAccent50
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                            }
                            Spacer(modifier = Modifier.height(Size80))
                        }
                    }
                    if (inventory.tag3 != null) {
                        Column {
                            Row {
                                Tag(text = inventory.tag3, color = Accent00, backgroundColor = Accent08)
                                Spacer(modifier = Modifier.width(8.dp))
                            }
                            Spacer(modifier = Modifier.height(Size80))
                        }
                    }
                    if (inventory.tag4 != null) {
                        Column {
                            Tag(
                                text = inventory.tag4,
                                color = ActionSuccess,
                                backgroundColor = ActionLightSuccess
                            )
                            Spacer(modifier = Modifier.height(Size80))
                        }
                    }
                }
            }
            Property(type= PropertyType.HorizontalMedium,name = "Description",value = inventory.description?:"Not Found")
            Spacer(modifier = Modifier.height(Size80))
            Property(type= PropertyType.HorizontalMedium,name = "Purchase Cost",value = inventory.purchaseCost?.toString()?:"Unknown")
            Spacer(modifier = Modifier.height(Size80))
            Property(type= PropertyType.HorizontalMedium,name = "Group",value = inventory.group?:"Unknown")
            Spacer(modifier = Modifier.height(Size80))
            Property(type= PropertyType.HorizontalMedium,name = "Warranty Expiration",value = inventory.warrantyExpiration?:"Unknown")
            Spacer(modifier = Modifier.height(48.dp))
        }
        Column(modifier = Modifier
            .width(60.dp)
            .height(60.dp)
            .align(Alignment.TopEnd),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier
                    .height(44.dp)
                    .width(44.dp)
                    .clickable(onClick = onHide),
                painter = painterResource(id = R.drawable.close),
                contentDescription = "close")
        }
    }
}