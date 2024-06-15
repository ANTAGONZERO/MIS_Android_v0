package com.example.mis1.ui.screens

import androidx.compose.foundation.background
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
import com.example.mis1.ui.composables.EquipmentItem
import com.example.mis1.ui.composables.Filters
import com.example.mis1.ui.composables.InventoryItem
import com.example.mis1.ui.composables.MachineItem
import com.example.mis1.ui.composables.SearchBar
import com.example.mis1.ui.composables.TabTitleRoundedActive
import com.example.mis1.ui.routes.InventoryTabs
import com.example.mis1.ui.theme.White
import com.example.mis1.viewmodels.InventoryScreenViewmodel


@Composable
fun InventoryScreen(
    viewModel: InventoryScreenViewmodel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White)
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TabTitleRoundedActive(
                text = "Machine",
                isActive = viewModel.visibleTab.value == InventoryTabs.Machine,
                onClick = viewModel::showMachineTab
            )
            TabTitleRoundedActive(
                text = "Equipments",
                isActive = viewModel.visibleTab.value == InventoryTabs.Equipment,
                onClick = viewModel::showEquipmentTab
            )
            TabTitleRoundedActive(
                text = "Inventory",
                isActive = viewModel.visibleTab.value == InventoryTabs.Inventory,
                onClick = viewModel::showInventoryTab
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            SearchBar(modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(8.dp))
            Filters()
        }
        Spacer(modifier = Modifier.height(16.dp))
        when (viewModel.visibleTab.value) {
            InventoryTabs.Machine -> {
                LazyColumn {
                    items(viewModel.machineList) { machine ->
                        MachineItem(machine = machine)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
            InventoryTabs.Inventory -> {
                LazyColumn {
                    items(viewModel.inventoryList) { inventory ->
                        InventoryItem(inventory = inventory)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
            InventoryTabs.Equipment -> {
                LazyColumn {
                    items(viewModel.equipmentList) { equipment ->
                        EquipmentItem(equipment = equipment)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}