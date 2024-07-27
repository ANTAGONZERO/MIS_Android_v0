package com.example.mis1.ui.composables.bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.R
import com.example.mis1.ui.theme.PageBgColor
import com.example.mis1.ui.theme.Primary04
import com.example.mis1.ui.theme.Primary10
import com.example.mis1.ui.theme.RoundedRectangleS
import com.example.mis1.ui.theme.Size120
import com.example.mis1.ui.theme.Size80

@Preview(widthDp = 256)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    value: String  = "",
    onSearchTextChanged: (String) -> Unit = {}
) {
    Row(
        modifier = modifier
            .height(40.dp)
            .background(color = PageBgColor, shape = RoundedRectangleS)
            .border(width = 1.dp, shape = RoundedRectangleS, color = Primary10)
            .padding(start = Size120, top = Size80, end = Size120, bottom = Size80),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .height(24.dp)
                .width(24.dp),
            painter = painterResource(id = R.drawable.search), contentDescription = "search"
        )
        Spacer(modifier = Modifier.width(8.dp))
        Box(modifier = Modifier.fillMaxWidth()) {
            if (value.isEmpty()) {
                Text(
                    text = "Search",
                    style = TextStyle(
                        color = Primary04,
                        fontSize = 16.sp,
                        lineHeight = 18.sp,
                        textAlign = TextAlign.Start
                    )
                )
            }
            BasicTextField(
                modifier = Modifier.fillMaxWidth(),
                value = value,
                onValueChange = onSearchTextChanged,
                singleLine = true,
                textStyle = TextStyle(
                    color = Primary04,
                    fontSize = 16.sp,
                    lineHeight = 18.sp
                )
            )
        }

    }
}