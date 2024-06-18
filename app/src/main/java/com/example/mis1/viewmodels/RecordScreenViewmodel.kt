package com.example.mis1.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mis1.common.Resource
import com.example.mis1.data.remote.machine.dto.ReservationResolved
import com.example.mis1.repository.MachineRepository
import com.example.mis1.ui.routes.RecordTabs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecordScreenViewmodel @Inject constructor(
    private val machineRepository: MachineRepository
) : ViewModel() {

    val reservationList = mutableStateListOf<ReservationResolved>()
    val issuableList = mutableStateListOf<ReservationResolved>()
    val purchasesList = mutableStateListOf<ReservationResolved>()

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
    private fun loadReservationList() {
        viewModelScope.launch {
            machineRepository.reservationList().collect { resource ->
                when (resource) {
                    is Resource.Success -> {
                        reservationList.clear()
                        reservationList.addAll(resource.data ?: emptyList())
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
            machineRepository.reservationList().collect { resource ->
                when (resource) {
                    is Resource.Success -> {
                        issuableList.clear()
                        issuableList.addAll(resource.data ?: emptyList())
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
            machineRepository.reservationList().collect { resource ->
                when (resource) {
                    is Resource.Success -> {
                        purchasesList.clear()
                        purchasesList.addAll(resource.data ?: emptyList())
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
}