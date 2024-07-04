package com.example.mis1.ui.composables.modal

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import com.example.mis1.data.remote.machine.dto.Machine
import com.example.mis1.ui.composables.Property
import com.example.mis1.ui.composables.enums.PropertyType
import com.example.mis1.ui.composables.list_item.sampleMachine
import com.example.mis1.ui.theme.PageBgColor
import com.example.mis1.ui.theme.RoundedRectangleXL
import com.example.mis1.ui.theme.SPrimary200
import com.example.mis1.ui.theme.SPrimary600
import com.example.mis1.ui.theme.SizeNone

@Preview
@Composable
fun MachineDetail(machine:Machine = sampleMachine){
    Box(modifier = Modifier){
        Column (modifier = Modifier
            .border(color = SPrimary200, width = SizeNone, shape = RoundedRectangleXL)
            .width(360.dp)
            .height(298.dp)
            .background(color = PageBgColor, shape = RoundedRectangleXL)
            .padding(start = 24.dp, top = 16.dp, end = 24.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween){
            Text(
                text = machine.name,
                fontSize = 24.sp,
                lineHeight = 36.sp,
                fontWeight = FontWeight(700),
                color = SPrimary600,
            )
            Property(type=PropertyType.HorizontalMedium,name = "Category",value = machine.category?:"Unknown")
            Property(type=PropertyType.HorizontalMedium,name = "Location",value = machine.location?:"Unknown")
            Property(type=PropertyType.HorizontalMedium,name = "UPC",value = machine.upc)
            Property(type=PropertyType.HorizontalMedium,name = "Manufacturer name",value = machine.manufacturer?:"Unknown")
            Property(type=PropertyType.HorizontalMedium,name = "Instances",value = machine.instances.toString())
            Property(type=PropertyType.HorizontalMedium,name = "Description",value = machine.description)
            Property(type=PropertyType.HorizontalMedium,name = "Availability",value = machine.availability)
        }
        Column(modifier = Modifier
            .width(60.dp)
            .height(60.dp)
            .align(Alignment.TopEnd),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier.height(44.dp).width(44.dp),
                painter = painterResource(id = R.drawable.close),
                contentDescription = "close")
        }
    }

}