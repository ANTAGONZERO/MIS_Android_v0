package com.example.mis1.ui.composables.list_item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mis1.R
import com.example.mis1.model.Tutorial
import com.example.mis1.ui.composables.Tag
import com.example.mis1.ui.composables.enums.TagType
import com.example.mis1.ui.theme.CircularEdge
import com.example.mis1.ui.theme.Primary01
import com.example.mis1.ui.theme.Primary02
import com.example.mis1.ui.theme.Primary05
import com.example.mis1.ui.theme.RoundedRectangleS
import com.example.mis1.ui.theme.RoundedRectangleXXL
import com.example.mis1.ui.theme.SAccent50
import com.example.mis1.ui.theme.SAccentSource
import com.example.mis1.ui.theme.SPrimary500
import com.example.mis1.ui.theme.Size120
import com.example.mis1.ui.theme.Size40
import com.example.mis1.ui.theme.SizeNone
import com.example.mis1.ui.theme.White

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TutorialItem(alreadyStarted: Boolean = false, percentage: Int = 0, tutorial: Tutorial) {
    Column(
        modifier = Modifier
            .background(color = White, shape = RoundedRectangleXXL)
            .border(width = SizeNone, color = Color(0x0D000000), shape = RoundedRectangleXXL)
            .fillMaxWidth()
            .padding(Size120),
    ) {
        Box {
            Row(modifier = Modifier.height(IntrinsicSize.Max)) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    FlowRow {
                        tutorial.tags.forEach {
                            val color =
                                when (it) {
                                    "Machine" -> Color(0xFF007BFF)
                                    "Inventory" -> Color(0xFFED2E7D)
                                    else -> Color(0xFFE85D5D)
                                }

                            val backgroundColor =
                                when (it) {
                                    "Machine" -> Color(0xFFCCE5FF)
                                    "Inventory" -> Color(0xFFF6E7ED)
                                    else -> Color(0xFFFBE2E2)
                                }
                            Box(modifier = Modifier.padding(bottom = 4.dp, end = 4.dp)){
                                Tag(
                                    type = TagType.VerySmall,
                                    text = it,
                                    color = color,
                                    backgroundColor = backgroundColor
                                )
                            }
                        }
                    }
                    Text(
                        text = tutorial.name,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        color = Primary02,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis

                    )
                    Text(
                        text = "${tutorial.videos.size} Videos · ${tutorial.totalLength} Hours",
                        fontSize = 12.sp,
                        color = Primary05,
                    )
                    Box(
                        modifier = Modifier
                            .background(color = SAccentSource, shape = RoundedRectangleS)
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = Size40),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Watch Now",
                            fontSize = 16.sp,
                            color = White,
                            maxLines = 1
                        )
                    }
                }
                Spacer(modifier = Modifier.width(Size120))
                Image(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clip(RoundedRectangleXXL),
                    painter = painterResource(id = R.drawable.lab),
                    contentDescription = "Laser Cutting",
                    contentScale = ContentScale.Crop
                )
            }
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .clip(CircleShape)
                    .background(color = White)
                    .border(width = SizeNone, color = SPrimary500, shape = CircleShape)
                    .padding(8.dp),
            ) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = R.drawable.add),
                    contentDescription = "Add",
                    tint = Primary01
                )
            }
        }
        val correctedPercentage = remember {
            if (percentage < 1)
                1
            else if (percentage > 100)
                100
            else
                percentage
        }
        if (alreadyStarted) {
            Spacer(modifier = Modifier.height(12.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                BoxWithConstraints(modifier = Modifier.weight(1f)) {
                    Box(
                        modifier = Modifier
                            .width(((100 - correctedPercentage + 5) * this.maxWidth.value / 100).dp)
                            .height(4.dp)
                            .align(Alignment.CenterEnd)
                            .background(color = SAccent50, shape = CircularEdge)
                    )
                    Box(
                        modifier = Modifier
                            .width((correctedPercentage * this.maxWidth.value / 100).dp)
                            .height(8.dp)
                            .background(color = SAccentSource, shape = CircularEdge)
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "$correctedPercentage%",
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(400),
                    color = SAccentSource
                )
            }
        }
    }

}