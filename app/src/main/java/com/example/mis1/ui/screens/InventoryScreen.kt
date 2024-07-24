package com.example.mis1.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mis1.ui.composables.Filters
import com.example.mis1.ui.composables.bar.SearchBar
import com.example.mis1.ui.composables.button.TabTitle
import com.example.mis1.ui.composables.list_item.EquipmentItem
import com.example.mis1.ui.composables.list_item.InventoryItem
import com.example.mis1.ui.composables.list_item.MachineItem
import com.example.mis1.ui.composables.modal.EquipmentDetail
import com.example.mis1.ui.composables.modal.InventoryDetail
import com.example.mis1.ui.composables.modal.MachineDetail
import com.example.mis1.ui.routes.InventoryTabs
import com.example.mis1.ui.routes.Screens
import com.example.mis1.ui.theme.RoundedTopRectangleXXL
import com.example.mis1.ui.theme.White
import com.example.mis1.viewmodels.InventoryScreenViewmodel
import com.google.gson.Gson
import kotlinx.coroutines.launch
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InventoryScreen(
    viewModel: InventoryScreenViewmodel = hiltViewModel(),
    navController: NavController
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
            TabTitle(
                text = "Machine",
                isActive = viewModel.visibleTab.value == InventoryTabs.Machine,
                onClick = viewModel::showMachineTab
            )
            TabTitle(
                text = "Equipments",
                isActive = viewModel.visibleTab.value == InventoryTabs.Equipment,
                onClick = viewModel::showEquipmentTab
            )
            TabTitle(
                text = "Inventory",
                isActive = viewModel.visibleTab.value == InventoryTabs.Inventory,
                onClick = viewModel::showInventoryTab
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            SearchBar(
                value = viewModel.searchText,
                onSearchTextChanged = viewModel::setSearchText,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Filters()
        }
        Spacer(modifier = Modifier.height(16.dp))
        when (viewModel.visibleTab.value) {
            InventoryTabs.Machine -> {
                LazyColumn {
                    itemsIndexed(viewModel.filteredMachineList) { index, machine ->
                        MachineItem(machine = machine, onClickBookMachine = {
                            navController.navigate(Screens.BookMachine.path+"/${machine.id}")
                        }, onShow = { viewModel.showDetail(index) })
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }

            InventoryTabs.Inventory -> {
                LazyColumn {
                    itemsIndexed(viewModel.filteredInventoryList) { index, inventory ->
                        InventoryItem(
                            inventory = inventory,
                            onShow = { viewModel.showDetail(index) },
                            onClickGet = {
                                val gson = Gson()
                                val jsonString  = gson.toJson(inventory)
                                val encodedJsonString = URLEncoder.encode(jsonString, StandardCharsets.UTF_8.toString())
                                navController.navigate(Screens.IssueInventory.path+"/$encodedJsonString")
                            }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }

            InventoryTabs.Equipment -> {
                LazyColumn {
                    itemsIndexed(viewModel.filteredEquipmentList) { index, equipment ->
                        EquipmentItem(equipment = equipment,onShow = { viewModel.showDetail(index) })
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }

        val scope = rememberCoroutineScope()
        val sheetState = rememberModalBottomSheetState()
        val onHide = {
            scope.launch {
                sheetState.hide()
                viewModel.hideDetail()
            }
        }

        if (viewModel.modalVisible.value)
            ModalBottomSheet(
                onDismissRequest = viewModel::hideDetail,
                dragHandle = { Box{} },
                shape = RoundedTopRectangleXXL,
                sheetState = sheetState,
                containerColor = White
            ) {
                when (viewModel.visibleTab.value) {
                    InventoryTabs.Machine -> MachineDetail(
                        machine = viewModel.filteredMachineList[viewModel.indexOfModalItem.intValue],
                        onHide = { onHide() })

                    InventoryTabs.Inventory -> InventoryDetail(
                        inventory = viewModel.filteredInventoryList[viewModel.indexOfModalItem.intValue],
                        onHide = { onHide() })

                    InventoryTabs.Equipment -> EquipmentDetail(
                        equipment = viewModel.filteredEquipmentList[viewModel.indexOfModalItem.intValue],
                        onHide = { onHide() })
                }
            }
    }
}