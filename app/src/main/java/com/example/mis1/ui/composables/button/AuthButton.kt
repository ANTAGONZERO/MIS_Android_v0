package com.example.mis1.ui.composables.button

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.ui.composables.enums.AuthButtonType
import com.example.mis1.ui.theme.Primary01
import com.example.mis1.ui.theme.Primary04
import com.example.mis1.ui.theme.Primary09
import com.example.mis1.ui.theme.RoundedRectangleM
import com.example.mis1.ui.theme.SAccentSource
import com.example.mis1.ui.theme.Size120
import com.example.mis1.ui.theme.White

@Preview(widthDp = 312)
@Composable
fun AuthButton(type: AuthButtonType = AuthButtonType.Filled, text:String="Login", onClick: () -> Unit = {}){
    when(type){
        AuthButtonType.Filled -> TextButton(
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = Size120),
            modifier = Modifier.fillMaxWidth()
                .background(color = SAccentSource,shape = RoundedRectangleM),
            shape = RoundedRectangleM,
            onClick = onClick) {
            Text(
                text = text,
                fontSize = 16.sp,
                fontWeight = FontWeight(700),
                color = White,
            )
        }
        AuthButtonType.Surrounded -> TextButton(
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = Size120),
            modifier = Modifier.fillMaxWidth()
                .border(width = 2.dp,color = SAccentSource, shape = RoundedRectangleM)
                .background(color = White, shape = RoundedRectangleM),
            shape = RoundedRectangleM,
            onClick = onClick) {
            Text(
                text = text,
                fontSize = 16.sp,
                fontWeight = FontWeight(700),
                color = Primary01,
            )
        }
        AuthButtonType.Disabled -> TextButton(
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = Size120),
            modifier = Modifier.fillMaxWidth()
                .background(color = Primary09, shape = RoundedRectangleM),
            shape = RoundedRectangleM,
            onClick = onClick) {
            Text(
                text = text,
                fontSize = 16.sp,
                fontWeight = FontWeight(700),
                color = Primary04,
            )
        }
    }

}