package com.example.mis1.ui.composables.list_item

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.data.remote.training.dto.Workshop
import com.example.mis1.ui.composables.button.EnrollButton
import com.example.mis1.ui.theme.RoundedRectangleXL
import com.example.mis1.ui.theme.SPrimary100
import com.example.mis1.ui.theme.Size120
import com.example.mis1.ui.theme.Size40
import com.example.mis1.ui.theme.SizeNone

@Composable
//@Preview(widthDp = 312, showBackground = true)
fun WorkshopItem(workshop: Workshop, onClickView: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedRectangleXL)
            .border(color = SPrimary100, width = SizeNone, shape = RoundedRectangleXL)
            .padding(Size120)
    ) {
        Text(
            text = "From:  ${workshop.fromDate}  ${workshop.fromTime.substring(0,5)}\n" +
                    "To:  ${workshop.toDate}  ${workshop.toTime.substring(0,5)}",
            fontSize = 12.sp,
            lineHeight = 18.sp,
            fontWeight = FontWeight(500),
            color = Color(0xFF12A594)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = workshop.title,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight(700),
            color = Color(0xFF3F3F3F),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Description",
            fontSize = 14.sp,
            fontWeight = FontWeight(500),
            color = Color(0xFF3F3F3F),
        )
        Text(
            text = workshop.description,
            fontSize = 12.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight(500),
            color = Color(0xFF5C5C5C),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = Size40, horizontal = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            ClickableText(
                text = AnnotatedString(
                    text = "View Detail", spanStyle = SpanStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF273F77)
                    )
                ),
                onClick = {onClickView()}
            )
        }
        Spacer(modifier = Modifier.height(Size40))
        EnrollButton()
    }
}