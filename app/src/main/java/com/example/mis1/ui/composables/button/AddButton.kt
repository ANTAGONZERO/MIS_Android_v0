package com.example.mis1.ui.composables.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.ui.theme.Primary01
import com.example.mis1.ui.theme.RoundedRectangleM
import com.example.mis1.ui.theme.SAccentSource
import com.example.mis1.ui.theme.Size120
import com.example.mis1.ui.theme.White

@Composable
fun AddButton(text:String,onClick :()->Unit){
    OutlinedButton(
        modifier  = Modifier.fillMaxWidth(),
        shape = RoundedRectangleM,
        contentPadding = PaddingValues(vertical = Size120),
        border = BorderStroke(width = 2.dp, color = Primary01),
        colors = ButtonDefaults.buttonColors().copy(containerColor = SAccentSource),
        onClick = onClick,
        content = {
            Text(
                modifier = Modifier
                    .padding(0.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight(500),
                color = White,
                text = text
            )
        }
    )
}