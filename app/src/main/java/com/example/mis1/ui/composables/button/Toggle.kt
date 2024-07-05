package com.example.mis1.ui.composables.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mis1.R

@Preview
@Composable
fun Toggle(checked:Boolean = false,onToggle:()->Unit={}) =
    if (checked) {
        Image(
            modifier = Modifier
                .width(32.dp)
                .height(16.dp)
                .clickable { onToggle() }
            ,
            painter = painterResource(id = R.drawable.setting_toggle_active),
            contentDescription = "on"
        )

    } else {

        Image(
            modifier = Modifier
                .width(32.dp)
                .height(16.dp)
                .clickable { onToggle() },
            painter = painterResource(id = R.drawable.setting_toggle_inactive),
            contentDescription = "on"
        )

    }

