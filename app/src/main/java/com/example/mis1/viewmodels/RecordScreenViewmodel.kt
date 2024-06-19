package com.example.mis1.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mis1.common.Resource
import com.example.mis1.common.searchInProperties
import com.example.mis1.data.remote.inventory.dto.ResolvedInventoryPurchase
import com.example.mis1.data.remote.inventory.dto.ResolvedIssuedInventory
import com.example.mis1.data.remote.machine.dto.ResolvedReservation
import com.example.mis1.repository.InventoryRepository
import com.example.mis1.repository.MachineRepository
import com.example.mis1.ui.routes.RecordTabs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecordScreenViewmodel @Inject constructor(
    private val machineRepository: MachineRepository,
    private val inventoryRepository: InventoryRepository
) : ViewModel() {

    private val reservationList = mutableStateListOf<ResolvedReservation>()
    private val issuableList = mutableStateListOf<ResolvedIssuedInventory>()
    private val purchasesList = mutableStateListOf<ResolvedInventoryPurchase>()

    val filteredReservationList = mutableStateListOf<ResolvedReservation>()
    val filteredIssuableList = mutableStateListOf<ResolvedIssuedInventory>()
    val filteredPurchasesList = mutableStateListOf<ResolvedInventoryPurchase>()

    val searchText = mutableStateOf("")

    val loadingReservationList = mutableStateOf(false)
    val loadingIssuableList = mutableStateOf(false)
    val loadingPurchaseList = mutableStateOf(false)

    val visibleTab  = mutableStateOf(RecordTabs.Reservation)

    init {
        loadReservationList()
        loadIssuableList()
        loadPurchasesList()
    }

    fun showReservationTab(){
        visibleTab.value = RecordTabs.Reservation
    }
    fun showIssuableTab(){
        visibleTab.value = RecordTabs.Issuable
    }
    fun showPurchaseTab(){
        visibleTab.value = RecordTabs.Purchase
    }
    private fun populateReservations(list: List<ResolvedReservation>) {
        reservationList.clear()
        reservationList.addAll(list)
        filteredReservationList.clear()
        filteredReservationList.addAll(list)
    }

    private fun populateIssuable(list: List<ResolvedIssuedInventory>) {
        issuableList.clear()
        issuableList.addAll(list)
        filteredIssuableList.clear()
        filteredIssuableList.addAll(list)
    }

    private fun populatePurchases(list: List<ResolvedInventoryPurchase>) {
        purchasesList.clear()
        purchasesList.addAll(list)
        filteredPurchasesList.clear()
        filteredPurchasesList.addAll(list)
    }
    private fun loadReservationList() {
        viewModelScope.launch {
            machineRepository.reservationList().collect { resource ->
                when (resource) {
                    is Resource.Success -> {
                        populateReservations(resource.data ?: emptyList())
                        loadingReservationList.value = false
                    }
                    is Resource.Error -> {
                        loadingReservationList.value = false
                    }
                    is Resource.Loading -> {
                        loadingReservationList.value = true
                    }
                }
            }
        }
    }

    private fun loadIssuableList() {
        viewModelScope.launch {
            inventoryRepository.issuedInventoryList().collect { resource ->
                when (resource) {
                    is Resource.Success -> {
                        populateIssuable(resource.data ?: emptyList())
                        loadingIssuableList.value = false
                    }
                    is Resource.Error -> {
                        loadingIssuableList.value = false
                    }
                    is Resource.Loading -> {
                        loadingIssuableList.value = true
                    }
                }
            }
        }
    }

    private fun loadPurchasesList() {
        viewModelScope.launch {
            inventoryRepository.purchasedInventoryList().collect { resource ->
                when (resource) {
                    is Resource.Success -> {
                        populatePurchases(resource.data ?: emptyList())
                        loadingPurchaseList.value = false
                    }
                    is Resource.Error -> {
                        loadingPurchaseList.value = false
                    }
                    is Resource.Loading -> {
                        loadingPurchaseList.value = true
                    }
                }
            }
        }
    }

    fun setSearchText(text: String){
        searchText.value = text
        filterLists()
    }

    private fun filterLists() {
        val search = searchText.value.lowercase()

        filteredReservationList.clear()
        filteredIssuableList.clear()
        filteredPurchasesList.clear()

        filteredReservationList.addAll(reservationList.filter { reservation ->
            reservation.searchInProperties(search) || reservation.machine.searchInProperties(search)
        })
        filteredIssuableList.addAll(issuableList.filter { issuable ->
            issuable.searchInProperties(search) || issuable.inventory.searchInProperties(search)
        })
        filteredPurchasesList.addAll(purchasesList.filter { purchase ->
            purchase.searchInProperties(search) || purchase.inventory.searchInProperties(search)
        })
    }
}