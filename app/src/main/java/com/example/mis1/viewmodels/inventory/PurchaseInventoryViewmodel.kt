package com.example.mis1.viewmodels.inventory

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mis1.common.ProjectType
import com.example.mis1.common.Resource
import com.example.mis1.data.remote.inventory.dto.Inventory
import com.example.mis1.data.remote.inventory.dto.InventoryPurchase
import com.example.mis1.data.remote.inventory.dto.PurchaseInventoryRequest
import com.example.mis1.data.remote.project.dto.Project
import com.example.mis1.repository.InventoryRepository
import com.example.mis1.repository.ProjectRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PurchaseInventoryViewmodel @Inject constructor(
    private val projectRepository: ProjectRepository,
    private val inventoryRepository: InventoryRepository
) : ViewModel() {

    val typeOfProject = mutableStateOf("")
    val projectDescription = mutableStateOf("")
    val quantity = mutableStateOf("")

    private val inventory = mutableStateOf<Inventory?>(null)

    private val userId: MutableState<Int?> = mutableStateOf(null)

    val project: MutableState<Project?> = mutableStateOf(null)

    var purchaseStatus by mutableStateOf<Resource<InventoryPurchase>>(Resource.Error(""))
        private set

    var projectList by mutableStateOf(emptyList<Project>())
        private set

    fun updateProject(newProject: Project) {
        project.value = newProject
        typeOfProject.value = ProjectType.fromId(newProject.type)!!.displayName
        projectDescription.value = newProject.description
    }

    private fun fetchProjectList() {
        viewModelScope.launch {
            projectRepository.listProject().collect {
                val list = it.data ?: emptyList()
                projectList = list.filter { project ->
                    project.student == userId.value || project.teammates.contains(userId.value)
                }
            }
        }
    }

    fun setQuantity(value: String) {
        quantity.value = value
    }

    fun setUserId(id:Int){
        userId.value = id
        fetchProjectList()
    }

    fun setInventory(newInventory: Inventory){
        inventory.value = newInventory
    }
    private fun toPurchaseInventoryRequest(): PurchaseInventoryRequest? {
        val inventoryId = inventory.value?.id ?: return null
        val quantityInt = quantity.value.toIntOrNull() ?: return null
        val projectId = project.value?.id?: return null
        val userId  = userId.value?: return null
        return PurchaseInventoryRequest(
            inventory = inventoryId,
            pickup = 0,
            project = projectId,
            purchasedBy = userId,
            quantity = quantityInt,
        )
    }

    fun purchase() {
        val request = toPurchaseInventoryRequest()
        if (request == null) {
            purchaseStatus = Resource.Error("Missing required fields for purchase request")
            return
        }

        viewModelScope.launch {
            purchaseStatus = Resource.Loading()
            inventoryRepository.purchaseInventory(request).collect{
                purchaseStatus = it
            }
        }
    }

}