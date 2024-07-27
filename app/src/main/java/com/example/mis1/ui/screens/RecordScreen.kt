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
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mis1.ui.composables.Filters
import com.example.mis1.ui.composables.list_item.IssuableItem
import com.example.mis1.ui.composables.list_item.PurchaseItem
import com.example.mis1.ui.composables.list_item.ReservationItem
import com.example.mis1.ui.composables.bar.SearchBar
import com.example.mis1.ui.composables.button.TabTitle
import com.example.mis1.ui.composables.enums.TabTitleType
import com.example.mis1.ui.routes.RecordTabs
import com.example.mis1.ui.theme.L
import com.example.mis1.ui.theme.M
import com.example.mis1.ui.theme.White
import com.example.mis1.viewmodels.RecordScreenViewmodel

@Composable
fun RecordScreen(
    viewModel: RecordScreenViewmodel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White)
    ) {
        Spacer(modifier = Modifier.height(L))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier.weight(1f)) {
                TabTitle(
                    type = TabTitleType.Record,
                    text = "Reservation",
                    isActive = viewModel.visibleTab.value == RecordTabs.Reservation,
                    onClick = viewModel::showReservationTab
                )
            }
            Box(modifier = Modifier.weight(1f)) {
                TabTitle(
                    type = TabTitleType.Record,
                    text = "Issuable",
                    isActive = viewModel.visibleTab.value == RecordTabs.Issuable,
                    onClick = viewModel::showIssuableTab
                )
            }
            Box(modifier = Modifier.weight(1f)) {
                TabTitle(
                    type = TabTitleType.Record,
                    text = "Purchase",
                    isActive = viewModel.visibleTab.value == RecordTabs.Purchase,
                    onClick = viewModel::showPurchaseTab
                )
            }

        }
        Spacer(modifier = Modifier.height(M))
        Row {
            SearchBar(value = viewModel.searchText.value, onSearchTextChanged = viewModel::setSearchText,modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(8.dp))
            Filters()
        }
        Spacer(modifier = Modifier.height(16.dp))
        when (viewModel.visibleTab.value) {
            RecordTabs.Reservation -> {
                LazyColumn {
                    items(viewModel.filteredReservationList) {
                        ReservationItem(machineReservation = it)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }

            RecordTabs.Issuable -> {
                LazyColumn {
                    items(viewModel.filteredIssuableList) {
                        IssuableItem(issuedInventory = it)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }

            RecordTabs.Purchase -> {
                LazyColumn {
                    items(viewModel.filteredPurchasesList) {
                        PurchaseItem(inventoryPurchase = it)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }

}