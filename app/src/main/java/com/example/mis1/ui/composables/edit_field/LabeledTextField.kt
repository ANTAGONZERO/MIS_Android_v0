package com.example.mis1.ui.composables.edit_field

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.ui.theme.Primary05
import com.example.mis1.ui.theme.Primary07
import com.example.mis1.ui.theme.RoundedRectangleM
import com.example.mis1.ui.theme.SizeNone

@Preview(backgroundColor = 0xFFFFFF, showBackground = true)
@Composable
fun LabeledTextField(
    value: String = "",
    onValueChange: (it: String) -> Unit = {},
    labelText: String = "Label",
    visualTransformation: VisualTransformation = VisualTransformation.None,
    rightComposable: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        visualTransformation = visualTransformation,
        textStyle = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight(400),
            color = Primary05
        ),
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = keyboardOptions,
        maxLines = 1,
        decorationBox = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(width = SizeNone, color = Primary07, shape = RoundedRectangleM)
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.weight(1f)) {
                    if (value.isEmpty()) {
                        Text(
                            text = labelText,
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight(400),
                                color = Primary05
                            )
                        )
                    }
                    it()
                }
                if (rightComposable!=null){
                    rightComposable()
                }
            }
        }
    )
}
