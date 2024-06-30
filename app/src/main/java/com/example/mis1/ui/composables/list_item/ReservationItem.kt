package com.example.mis1.ui.composables.list_item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.R
import com.example.mis1.data.remote.machine.dto.ResolvedReservation
import com.example.mis1.ui.composables.Property
import com.example.mis1.ui.theme.M
import com.example.mis1.ui.theme.Primary01
import com.example.mis1.ui.theme.Primary09
import com.example.mis1.ui.theme.Primary11
import com.example.mis1.ui.theme.RoundedRectangleM
import com.example.mis1.ui.theme.Size40
import com.example.mis1.ui.theme.Size80
import com.example.mis1.ui.theme.SizeNone
import com.example.mis1.ui.theme.White


val sampleReservation = ResolvedReservation(
    approved = "Pending",
    approvedBy = null,
    approvedStatus = "0",
    createdAt = "2024-06-12T12:21:38.963514+05:30",
    endTime = "2024-06-12T12:21:25+05:30",
    id = 1,
    lastUpdatedAt = "2024-06-12T12:21:38.963526+05:30",
    machine = sampleMachine,
    reservedBy = 6,
    reservedDate = "2024-06-12",
    startTime = "2024-06-12T12:21:25+05:30"
)

@Preview(widthDp = 312)
@Composable
fun ReservationItem(resolvedReservation: ResolvedReservation = sampleReservation) {
    Column(
        modifier = Modifier
            .background(color = White, shape = RoundedRectangleM)
            .clipToBounds()
            .border(width = SizeNone, color = Primary09, shape = RoundedRectangleM)


    ) {
        Column(
            modifier = Modifier.padding(start = Size80, top = Size40, end = Size80, bottom = Size40)
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .defaultMinSize(minHeight = 27.dp),
                    text = resolvedReservation.machine.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight(500),
                    color = Primary01,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Image(
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp),
                    painter = painterResource(id = R.drawable.more_vertical_circle),
                    contentDescription = "more"
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "Description: " + sampleReservation.machine.description,
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                color = Primary01,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        HorizontalDivider()

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
                .background(
                    color = Primary11,
                    shape = RoundedCornerShape(bottomStart = M, bottomEnd = M)
                )
        ){
            Box(modifier=Modifier.weight(1f)){
                Property(name = "Category",value =resolvedReservation.machine.category)
            }
            VerticalDivider()
            Property(name = "Date",value =resolvedReservation.reservedDate)
            VerticalDivider()
            val startTime = resolvedReservation.startTime.substring(11, 16)
            val endTime = resolvedReservation.endTime.substring(11,16)
            Property(
                name = "Time Range",
                value = "$startTime to $endTime"
            )
        }
    }
}