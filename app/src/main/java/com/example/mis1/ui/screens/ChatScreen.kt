package com.example.mis1.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mis1.ui.composables.Filters
import com.example.mis1.ui.composables.MessageItem
import com.example.mis1.ui.composables.SearchBar

@Preview(widthDp = 312, showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun ChatScreen(){
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            SearchBar(modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(8.dp))
            Filters()
        }
        Spacer(modifier = Modifier.height(8.dp))
        MessageItem()
        Spacer(modifier = Modifier.height(8.dp))
        MessageItem()
        Spacer(modifier = Modifier.height(8.dp))
        MessageItem()
        Spacer(modifier = Modifier.height(8.dp))
        MessageItem()
        Spacer(modifier = Modifier.height(8.dp))
        MessageItem()
        Spacer(modifier = Modifier.height(8.dp))
        MessageItem()

    }
}