package com.example.mis1.viewmodels.inventory

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mis1.common.ProjectType
import com.example.mis1.common.Resource
import com.example.mis1.common.toTwoDigitString
import com.example.mis1.data.remote.inventory.dto.Inventory
import com.example.mis1.data.remote.inventory.dto.IssueInventoryRequest
import com.example.mis1.data.remote.inventory.dto.IssuedInventory
import com.example.mis1.data.remote.project.dto.Project
import com.example.mis1.model.Date
import com.example.mis1.repository.InventoryRepository
import com.example.mis1.repository.ProjectRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IssueInventoryViewmodel @Inject constructor(
    private val projectRepository: ProjectRepository,
    private val inventoryRepository: InventoryRepository
) : ViewModel() {

    val typeOfProject = mutableStateOf("")
    val projectDescription = mutableStateOf("")
    val startDate = mutableStateOf<Date?>(null)
    val endDate = mutableStateOf<Date?>(null)
    val quantity = mutableStateOf("")
    val unit = mutableStateOf("")

    private val inventory = mutableStateOf<Inventory?>(null)

    private val userId: MutableState<Int?> = mutableStateOf(null)

    val project: MutableState<Project?> = mutableStateOf(null)

    var issueStatus by mutableStateOf<Resource<IssuedInventory>>(Resource.Error(""))
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

    fun setStartDate(value: Date) {
        startDate.value = value
    }

    fun setEndDate(value: Date) {
        endDate.value = value
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
    private fun convertDate(date: Date): String {
        return "${date.year}-${date.month.toTwoDigitString()}-${date.day.toTwoDigitString()}"
    }
    private fun toIssueInventoryRequest(): IssueInventoryRequest? {
        val inventoryId = inventory.value?.id ?: return null
        val quantityInt = quantity.value.toIntOrNull() ?: return null
        val projectId = project.value?.id?: return null
        val userId  = userId.value?: return null
        val startDate = startDate.value?:return null
        val endDate = endDate.value?: return null
        return IssueInventoryRequest(
            inventory = inventoryId,
            pickup = 0,
            project = projectId,
            issuedBy = userId,
            quantity = quantityInt,
            issuedFrom = convertDate(startDate),
            issuedTill = convertDate(endDate)
        )
    }

    fun issue() {
        val request = toIssueInventoryRequest()
        if (request == null) {
            issueStatus = Resource.Error("Missing required fields for purchase request")
            return
        }

        viewModelScope.launch {
            issueStatus = Resource.Loading()
            inventoryRepository.issueInventory(request).collect{
                issueStatus = it
            }
        }
    }

}