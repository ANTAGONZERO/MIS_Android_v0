package com.example.mis1.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mis1.common.Resource
import com.example.mis1.data.remote.equipment.dto.Equipment
import com.example.mis1.data.remote.inventory.dto.Inventory
import com.example.mis1.data.remote.machine.dto.Machine
import com.example.mis1.repository.EquipmentRepository
import com.example.mis1.repository.InventoryRepository
import com.example.mis1.repository.MachineRepository
import com.example.mis1.ui.routes.InventoryTabs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class InventoryScreenViewmodel @Inject constructor(
    private val inventoryRepository: InventoryRepository,
    private val machineRepository: MachineRepository,
    private val equipmentRepository: EquipmentRepository
) : ViewModel() {

    val inventoryList = mutableStateListOf<Inventory>()
    val machineList = mutableStateListOf<Machine>()
    val equipmentList  = mutableStateListOf<Equipment>()

    val loadingInventoryList = mutableStateOf(false)
    val loadingMachineList = mutableStateOf(false)
    val loadingEquipmentList = mutableStateOf(false)

    val visibleTab = mutableStateOf(InventoryTabs.Machine)

    init {
        fetchInventoryList()
        fetchMachineList()
        fetchEquipmentList()
    }

    fun showMachineTab(){
        visibleTab.value = InventoryTabs.Machine
    }

    fun showEquipmentTab(){
        visibleTab.value = InventoryTabs.Equipment
    }

    fun showInventoryTab(){
        visibleTab.value = InventoryTabs.Inventory
    }

    private fun fetchInventoryList() {
        viewModelScope.launch {
            loadingInventoryList.value = true
            inventoryRepository.inventoryList().collect { resource ->
                when (resource) {
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        inventoryList.clear()
                        inventoryList.addAll(resource.data ?: emptyList())
                    }
                    is Resource.Error -> {}
                }
                loadingInventoryList.value = false
            }
        }
    }

    private fun fetchMachineList() {
        viewModelScope.launch {
            loadingMachineList.value = true
            machineRepository.machineList().collect { resource ->
                when (resource) {
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        machineList.clear()
                        machineList.addAll(resource.data ?: emptyList())
                    }
                    is Resource.Error -> {}
                }
                loadingMachineList.value = false
            }
        }
    }

    private fun fetchEquipmentList() {
        viewModelScope.launch {
            loadingEquipmentList.value = true
            equipmentRepository.equipmentList().collect { resource ->
                when (resource) {
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        equipmentList.clear()
                        equipmentList.addAll(resource.data ?: emptyList())
                    }
                    is Resource.Error -> {}
                }
                loadingEquipmentList.value = false
            }
        }
    }

}

