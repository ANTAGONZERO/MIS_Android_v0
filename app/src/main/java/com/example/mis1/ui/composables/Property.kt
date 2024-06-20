package com.example.mis1.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.ui.composables.enums.PropertyType
import com.example.mis1.ui.theme.Primary01
import com.example.mis1.ui.theme.Primary02
import com.example.mis1.ui.theme.Primary03
import com.example.mis1.ui.theme.Primary04
import com.example.mis1.ui.theme.Size80

@Preview
@Composable
fun Property(name:String = "Category",value:String="Mechanical",type:PropertyType=PropertyType.Small){
    when(type) {
        PropertyType.Small ->Column(
            modifier = Modifier
                .padding(start = Size80, top = Size80, end = Size80, bottom = Size80),
        ) {
            Text(
                text = name,
                fontSize = 12.sp,
                fontWeight = FontWeight(400),
                color = Primary03
            )
            Text(
                text = value,
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                color = Primary01,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        PropertyType.Medium -> Column {
            Text(
                text = name,
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                color = Primary04
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = value,
                fontSize = 16.sp,
                fontWeight = FontWeight(500),
                color = Primary02,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}