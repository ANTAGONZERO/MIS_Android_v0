package com.example.mis1.viewmodels.training

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mis1.data.remote.training.dto.Workshop
import com.example.mis1.data.remote.user.dto.User
import com.example.mis1.model.Tutorial
import com.example.mis1.repository.TrainingRepository
import com.example.mis1.ui.routes.TrainingTabs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrainingViewmodel @Inject constructor(
    private val trainingRepository: TrainingRepository
) : ViewModel() {
    var registeredWorkshops = mutableStateListOf<Int>()
        private set
    var visibleTab by mutableStateOf(TrainingTabs.TUTORIALS)
        private set
    var tutorials = mutableStateListOf<Tutorial>()
        private set
    var workshops = mutableStateListOf<Workshop>()
        private set
    var user by mutableStateOf<User?>(null)
        private set
    var workshopDetailVisible by mutableStateOf(false)
        private set

    var workshopDetailIndex by mutableIntStateOf(-1)

    fun goto(tab: TrainingTabs) {
        visibleTab = tab
    }

    init {
        fetchTutorials()
    }

    fun showWorkshopDetailModal(index:Int){
        workshopDetailIndex = index
        workshopDetailVisible = true
    }

    fun hideWorkshopDetail(){
        workshopDetailVisible = false
    }
    private fun fetchTutorials() {
        viewModelScope.launch {
            trainingRepository.tutorialList().collect {
                it.data?.let { tutorialList ->
                    tutorials.clear()
                    tutorials.addAll(tutorialList)
                } ?: run {
                    tutorials.clear()
                }
            }
        }
    }
    fun updateUser(newUser: User){
        user = newUser
        fetchWorkshops()
    }
    private fun fetchWorkshops() {
        if(user==null)
            return
        viewModelScope.launch {
            trainingRepository.workshopList().collect {
                it.data?.let { workshopList ->
                    workshops.clear()
                    workshops.addAll(workshopList.filter { workshop ->
                        val currentYear:Int? = user!!.currentYear?.toInt()
                        workshop.eligibleBranches
                        val department = user!!.department
                        workshop.eligibleYears.contains(currentYear) && workshop.eligibleBranches.contains(department)
                    })
                } ?: run {
                    workshops.clear()
                }
            }
        }
    }

    fun registerForWorkshop(index:Int){
        viewModelScope.launch {
            trainingRepository.registerForWorkshop(workshops[index].id).collect{
                it.data?.let { registeredWorkshops.add(index) }
            }
        }
    }
}