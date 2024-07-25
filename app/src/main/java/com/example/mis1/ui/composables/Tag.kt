package com.example.mis1.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.ui.composables.enums.TagType
import com.example.mis1.ui.theme.CircularEdge
import com.example.mis1.ui.theme.RoundedRectangleXS
import com.example.mis1.ui.theme.SPrimary50
import com.example.mis1.ui.theme.SPrimarySource
import com.example.mis1.ui.theme.Size20

@Preview(backgroundColor = 0xFFFFFFFF)
@Composable
fun Tag(type:TagType = TagType.Small, text:String = "Cutting", color:Color = SPrimarySource, backgroundColor:Color =  SPrimary50){
    when(type){
        TagType.VerySmall -> Row (modifier = Modifier
            .background(color = backgroundColor, shape = RoundedRectangleXS)
            .padding(start = 8.dp, top = Size20, end = 8.dp, bottom = Size20),
            verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = text,
                color = color,
                fontSize = 8.sp,
                lineHeight = 12.sp,
                fontWeight = FontWeight(500),
            )
        }
        TagType.Small -> Row (modifier = Modifier
            .height(22.dp)
            .background(color = backgroundColor, shape = CircularEdge)
            .padding(start = 8.dp, top = Size20, end = 8.dp, bottom = Size20),
            verticalAlignment = Alignment.CenterVertically){
            Text(
                text = text,
                color = color,
                fontSize = 14.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight(400),
            )
        }
        TagType.Medium -> Row (modifier = Modifier
            .height(28.dp)
            .background(color = backgroundColor, shape = CircularEdge)
            .padding(start = 16.dp, top = Size20, end = 16.dp, bottom = Size20),
            verticalAlignment = Alignment.CenterVertically){
            Text(
                text = text,
                color = color,
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(400),
            )
        }

    }

}