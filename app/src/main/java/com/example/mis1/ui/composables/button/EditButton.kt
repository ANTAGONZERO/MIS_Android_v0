package com.example.mis1.ui.composables.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import com.example.mis1.ui.theme.CircularEdge
import com.example.mis1.ui.theme.Primary04
import com.example.mis1.ui.theme.Size40
import com.example.mis1.ui.theme.Size80
import com.example.mis1.ui.theme.SizeNone

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun EditButton(){
    Row(modifier = Modifier
        .border(width = SizeNone, color = Primary04, shape = CircularEdge)
        .padding(vertical = Size40, horizontal = Size80),
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = "Edit", fontSize = 12.sp,
            fontWeight = FontWeight(400),
            color = Primary04
        )
        Spacer(modifier = Modifier.width(8.dp))
        Image(
            modifier = Modifier.width(16.dp).height(16.dp),
            painter = painterResource(id = R.drawable.edit),
            contentDescription = "edit" )
    }
}