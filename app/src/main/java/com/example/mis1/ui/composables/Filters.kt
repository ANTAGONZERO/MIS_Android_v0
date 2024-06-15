package com.example.mis1.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mis1.R
import com.example.mis1.ui.theme.PageBgColor
import com.example.mis1.ui.theme.Primary10
import com.example.mis1.ui.theme.RoundedRectangleS

@Preview
@Composable
fun Filters() {
    Row(modifier = Modifier
        .width(40.dp)
        .height(40.dp)
        .border(color = Primary10, shape = RoundedRectangleS, width = 1.dp)
        .background(color = PageBgColor, shape= RoundedRectangleS),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .height(24.dp)
                .width(24.dp),
            painter = painterResource(id = R.drawable.filter),
            contentDescription = "filter"
        )
    }
}