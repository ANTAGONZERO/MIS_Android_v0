package com.example.mis1.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mis1.ui.composables.Filters
import com.example.mis1.ui.composables.bar.SearchBar
import com.example.mis1.ui.composables.button.TabTitle
import com.example.mis1.ui.composables.list_item.ProjectItem
import com.example.mis1.ui.theme.M
import com.example.mis1.viewmodels.ProjectListViewModel

@Composable
fun ProjectScreen(viewModel:ProjectListViewModel = hiltViewModel()){
    Column (modifier = Modifier.fillMaxSize()){
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
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn(verticalArrangement = Arrangement.spacedBy(M)) {
            items(viewModel.projects){item ->
                ProjectItem(item)
            }
        }
    }
}