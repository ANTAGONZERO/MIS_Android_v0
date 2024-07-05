package com.example.mis1.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mis1.common.Resource
import com.example.mis1.common.searchInProperties
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

    private val inventoryList = mutableStateListOf<Inventory>()
    private val machineList = mutableStateListOf<Machine>()
    private val equipmentList  = mutableStateListOf<Equipment>()

    val filteredInventoryList = mutableStateListOf<Inventory>()
    val filteredMachineList = mutableStateListOf<Machine>()
    val filteredEquipmentList = mutableStateListOf<Equipment>()

    val searchText =  mutableStateOf("")

    val loadingInventoryList = mutableStateOf(false)
    val loadingMachineList = mutableStateOf(false)
    val loadingEquipmentList = mutableStateOf(false)

    val visibleTab = mutableStateOf(InventoryTabs.Machine)
    val indexOfModalItem  = mutableIntStateOf(-1)
    val modalVisible = mutableStateOf(false)
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

    fun setSearchText(text:String){
        searchText.value = text
        filterLists()
    }

    fun hideDetail(){
        modalVisible.value = false
    }
    fun showDetail(index:Int){
        indexOfModalItem.intValue = index
        modalVisible.value = true
    }

    private fun populateInventory(list: List<Inventory>) {
        inventoryList.clear()
        inventoryList.addAll(list)
        filteredInventoryList.clear()
        filteredInventoryList.addAll(list)
    }

    private fun populateMachines(list: List<Machine>) {
        machineList.clear()
        machineList.addAll(list)
        filteredMachineList.clear()
        filteredMachineList.addAll(list)
    }

    private fun populateEquipment(list: List<Equipment>) {
        equipmentList.clear()
        equipmentList.addAll(list)
        filteredEquipmentList.clear()
        filteredEquipmentList.addAll(list)
    }

    private fun fetchInventoryList() {
        viewModelScope.launch {
            inventoryRepository.inventoryList().collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        loadingInventoryList.value = true
                    }
                    is Resource.Success -> {
                        populateInventory(resource.data ?: emptyList())
                        loadingInventoryList.value = false
                    }
                    is Resource.Error -> {
                        loadingInventoryList.value = false
                    }
                }
            }
        }
    }

    private fun fetchMachineList() {
        viewModelScope.launch {
            machineRepository.machineList().collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        loadingMachineList.value = true
                    }
                    is Resource.Success -> {
                        populateMachines(resource.data ?: emptyList())
                        loadingMachineList.value = false
                    }
                    is Resource.Error -> {
                        loadingMachineList.value = false
                    }
                }

            }
        }
    }

    private fun fetchEquipmentList() {
        viewModelScope.launch {
            equipmentRepository.equipmentList().collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        loadingEquipmentList.value = true
                    }
                    is Resource.Success -> {
                        populateEquipment(resource.data ?: emptyList())
                        loadingEquipmentList.value = false
                    }
                    is Resource.Error -> {
                        loadingEquipmentList.value = false
                    }
                }
            }
        }
    }

    private fun filterLists() {
        val search = searchText.value.lowercase()
        Log.d("searching string",search)
        filteredInventoryList.clear()
        filteredEquipmentList.clear()
        filteredMachineList.clear()

        filteredInventoryList.addAll(inventoryList.filter { inventory ->
            inventory.searchInProperties(search)
        })
        filteredEquipmentList.addAll(equipmentList.filter { equipment ->
            equipment.searchInProperties(search)
        })
        filteredMachineList.addAll(machineList.filter { machine ->
            machine.searchInProperties(search)
        })
    }
}

