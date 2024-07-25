package com.example.mis1.ui.composables.modal

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import com.example.mis1.data.remote.equipment.dto.Equipment
import com.example.mis1.ui.composables.Property
import com.example.mis1.ui.composables.enums.PropertyType
import com.example.mis1.ui.composables.list_item.sampleEquipment
import com.example.mis1.ui.theme.PageBgColor
import com.example.mis1.ui.theme.RoundedTopRectangleXXXL
import com.example.mis1.ui.theme.SPrimary200
import com.example.mis1.ui.theme.SPrimary600
import com.example.mis1.ui.theme.SizeNone

@Preview
@Composable
fun EquipmentDetail(equipment: Equipment = sampleEquipment, onHide:()->Unit ={}){
    Box(modifier = Modifier){
        Column (modifier = Modifier
            .border(color = SPrimary200, width = SizeNone, shape = RoundedTopRectangleXXXL)
            .width(360.dp)
            .height(298.dp)
            .background(color = PageBgColor, shape = RoundedTopRectangleXXXL)
            .padding(start = 24.dp, top = 16.dp, end = 24.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween){
            Text(
                text = equipment.name,
                fontSize = 24.sp,
                lineHeight = 36.sp,
                fontWeight = FontWeight(700),
                color = SPrimary600,
            )
            Property(type=PropertyType.HorizontalMedium,name = "Category",value = equipment.category)
            Property(type=PropertyType.HorizontalMedium,name = "Location",value = equipment.location)
            Property(type=PropertyType.HorizontalMedium,name = "UPC",value = equipment.upc)
            Property(type=PropertyType.HorizontalMedium,name = "Manufacturer name",value = equipment.manufacturer)
            Property(type=PropertyType.HorizontalMedium,name = "Instances",value = equipment.instances.toString())
            Property(type=PropertyType.HorizontalMedium,name = "Description",value = equipment.description)
            Property(type=PropertyType.HorizontalMedium,name = "Purchase Cost",value = equipment.purchaseCost)
            Property(type=PropertyType.HorizontalMedium,name = "Status",value = equipment.status)
            Property(type=PropertyType.HorizontalMedium,name = "Warranty Expiration",value = equipment.warrantyExpiration?:"Unknown")
            Spacer(modifier = Modifier.height(48.dp))
        }
        Column(modifier = Modifier
            .width(60.dp)
            .height(60.dp)
            .align(Alignment.TopEnd),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier.height(44.dp).width(44.dp)
                    .clickable(onClick = onHide),
                painter = painterResource(id = R.drawable.close),
                contentDescription = "close")
        }
    }

}