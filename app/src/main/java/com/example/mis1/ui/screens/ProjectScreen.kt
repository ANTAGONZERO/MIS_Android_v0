package com.example.mis1.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mis1.ui.composables.Filters
import com.example.mis1.ui.composables.list_item.ProjectItem
import com.example.mis1.ui.composables.bar.SearchBar
import com.example.mis1.ui.composables.TabTitle
import com.example.mis1.ui.theme.M

@Preview(showBackground = true, backgroundColor = 0xFFFFFF, widthDp = 312)
@Composable
fun ProjectScreen(){
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TabTitle(
                text = "  My Projects  ",
                isActive = true
//                isActive = viewModel.visibleTab.value == InventoryTabs.Machine,
//                onClick = viewModel::showMachineTab
            )
            TabTitle(
                text = "  Explore Projects  ",
//                isActive = true
//                isActive = viewModel.visibleTab.value == InventoryTabs.Equipment,
//                onClick = viewModel::showEquipmentTab
            )

        }
        Spacer(modifier = Modifier.height(M))
        Row {
            SearchBar(modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(8.dp))
            Filters()
        }
        Column(Modifier.verticalScroll(rememberScrollState())) {
            Spacer(modifier = Modifier.height(M))
            ProjectItem()
            Spacer(modifier = Modifier.height(M))
            ProjectItem()
            Spacer(modifier = Modifier.height(M))
            ProjectItem()
            Spacer(modifier = Modifier.height(M))
            ProjectItem()
            Spacer(modifier = Modifier.height(M))
            ProjectItem()
        }


    }
}