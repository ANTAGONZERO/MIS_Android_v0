package com.example.mis1.ui.composables.edit_field

import android.app.DatePickerDialog
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
import com.example.mis1.ui.theme.Primary01
import com.example.mis1.ui.theme.Primary03
import com.example.mis1.ui.theme.RoundedRectangleS
import com.example.mis1.ui.theme.Size120
import com.example.mis1.ui.theme.White
import java.util.Calendar

@Composable
fun EditDateField(date: String, onDateChange: (it: String) -> Unit = { }) {
    val selectedDate = date.ifEmpty { "dd/mm/yy" }
    val calendar = Calendar.getInstance()

    val datePickerDialog = DatePickerDialog(
        LocalContext.current,
        { _, year, month, dayOfMonth ->
            val twoDigitYear = (year % 100).toTwoDigitString()
            onDateChange("${dayOfMonth.toTwoDigitString()}/${(month + 1).toTwoDigitString()}/$twoDigitYear")
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    Box(
        modifier = Modifier
            .border(width = 1.dp, color = Primary01, shape = RoundedRectangleS)
            .background(color = White, shape = RoundedRectangleS)
            .clickable { datePickerDialog.show() }
            .padding(horizontal = Size120, vertical = 8.dp)
    ) {
        Text(
            text = selectedDate,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight(400),
            color = Primary03,
        )
    }
}