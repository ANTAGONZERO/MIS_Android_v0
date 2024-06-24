package com.example.mis1.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.R
import com.example.mis1.ui.theme.Primary02
import com.example.mis1.ui.theme.Primary03
import com.example.mis1.ui.theme.Primary05
import com.example.mis1.ui.theme.Primary10
import com.example.mis1.ui.theme.RoundedRectangleM
import com.example.mis1.ui.theme.Size120
import com.example.mis1.ui.theme.Size40
import com.example.mis1.ui.theme.SizeNone

@Preview(widthDp = 312)
@Composable
fun MessageItem(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(IntrinsicSize.Max)
        .border(width = SizeNone, shape = RoundedRectangleM, color = Primary10)
        .background(color = Color(0xFFF7F7F7), shape = RoundedRectangleM)
        .padding(Size120),
    ){
        Box(modifier = Modifier
            .height(40.dp)
            .width(40.dp)
            .background(
                color = Color(0xFFD9D9D9), shape = RoundedCornerShape(20.dp)
            )
        )
        Spacer(modifier = Modifier.width(Size40))
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()) {
            Row (modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
                ){
                Text(
                    text = "User Name",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    color = Primary02,
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "04/05/24",
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    color = Primary03
                )
                Image(
                    modifier=Modifier.width(16.dp).height(16.dp),
                    painter = painterResource(id = R.drawable.more_vertical_circle),
                    contentDescription = "more",
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Message.................................................",
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = Primary05
            )
        }

    }
}