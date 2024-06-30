package com.example.mis1.ui.composables.edit_field

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import com.example.mis1.ui.theme.Primary03
import androidx.compose.ui.text.TextStyle

@Composable
fun NumberInputField(
    hours: String,
    onValueChange: (String) -> Unit,
    hint: String
) {
    Box(modifier = Modifier.width(IntrinsicSize.Max)) {
        if (hours.isEmpty()) {
            Text(
                text = hint,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(400),
                    color = Primary03
                )
            )
        }
        BasicTextField(
            value = hours,
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            textStyle = TextStyle(
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(400),
                color = Primary03
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}
