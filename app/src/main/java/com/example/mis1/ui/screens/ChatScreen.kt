package com.example.mis1.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mis1.ui.composables.Filters
import com.example.mis1.ui.composables.list_item.MessageItem
import com.example.mis1.ui.composables.bar.SearchBar

@Preview(widthDp = 312, showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun ChatScreen(){
    Column(modifier = Modifier.fillMaxSize()) {
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