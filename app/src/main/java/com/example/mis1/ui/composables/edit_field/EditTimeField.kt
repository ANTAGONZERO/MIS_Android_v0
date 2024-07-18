package com.example.mis1.ui.composables.edit_field

import android.app.TimePickerDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.common.toTwoDigitString
import com.example.mis1.model.Time
import com.example.mis1.ui.theme.Primary01
import com.example.mis1.ui.theme.Primary03
import com.example.mis1.ui.theme.RoundedRectangleS
import com.example.mis1.ui.theme.White

@Composable
fun EditTimeField(time:Time?,onTimeChanged:(it:Time)->Unit){
    val textDisplayed = if(time == null) { "00:00" } else "${time.hour.toTwoDigitString()}:${time.minute.toTwoDigitString()}"
    val timePickerDialog = TimePickerDialog(
        LocalContext.current,
        {_, hour : Int, minute: Int ->
            onTimeChanged(Time(hour = hour,minute = minute))
        }, 0, 0, true
    )
    Box(
        modifier = Modifier
            .border(width = 1.dp, color = Primary01, shape = RoundedRectangleS)
            .background(color = White, shape = RoundedRectangleS)
            .clickable { timePickerDialog.show() }
            .padding(horizontal = 8.dp, vertical = 8.dp)
    ) {
        Text(
            text = textDisplayed,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight(400),
            color = Primary03,
        )
    }
}