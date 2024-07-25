package com.example.mis1.viewmodels.inventory

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mis1.common.Resource
import com.example.mis1.common.toTwoDigitString
import com.example.mis1.data.remote.machine.dto.MachineReservationRequest
import com.example.mis1.data.remote.project.dto.Project
import com.example.mis1.model.Date
import com.example.mis1.model.Time
import com.example.mis1.repository.MachineRepository
import com.example.mis1.repository.ProjectRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookMachineViewmodel @Inject constructor(
    private val machineRepository: MachineRepository,
    private val projectRepository: ProjectRepository
) : ViewModel() {

    val date: MutableState<Date?> = mutableStateOf(null)
    val hours: MutableState<String> = mutableStateOf("")
    val startTime: MutableState<Time?> = mutableStateOf(null)
    val endTime: MutableState<Time?> = mutableStateOf(null)

    val projectTitle: MutableState<String> = mutableStateOf("")
    val projectDetails: MutableState<String> = mutableStateOf("")

    val machine: MutableState<Int> = mutableStateOf(0)
    val project: MutableState<Project?> = mutableStateOf(null)
    private val reservedBy: MutableState<Int> = mutableStateOf(0)

    val reservationStatus = mutableStateOf<Resource<Unit>>(Resource.Error(""))
    var projectList by mutableStateOf(emptyList<Project>())
        private set

    fun updateDate(newDate: Date) {
        date.value = newDate
    }

    fun updateHours(newHours: String) {
        hours.value = newHours
    }

    fun updateStartTime(newStartTime: Time) {
        startTime.value = newStartTime
    }

    fun updateEndTime(newEndTime: Time) {
        endTime.value = newEndTime
    }

    fun updateProject(newProject: Project) {
        project.value = newProject
        projectTitle.value = newProject.title
        projectDetails.value = newProject.description
    }

    fun updateMachine(newMachine: Int) {
        machine.value = newMachine
    }

    fun updateReservedBy(person: Int) {
        reservedBy.value = person
        fetchProjectList() // Update the project list when reservedBy changes
    }

    private fun convertDate(date: Date): String {
        return "${date.year}-${date.month.toTwoDigitString()}-${date.day.toTwoDigitString()}"
    }

    private fun combineDateAndTime(date: Date, time: Time): String {
        val isoDate = convertDate(date)
        return "$isoDate ${time.hour.toTwoDigitString()}:${time.minute.toTwoDigitString()}"
    }

    private fun toMachineReservationRequest(): MachineReservationRequest? {
        val start = startTime.value
        val end = endTime.value
        val selectedDate = date.value
        val selectedProject = project.value

        if (start == null || end == null || selectedDate == null || selectedProject == null)
            return null

        val isoDate = convertDate(selectedDate)
        val isoStartTime = combineDateAndTime(selectedDate, start)
        val isoEndTime = combineDateAndTime(selectedDate, end)

        return MachineReservationRequest(
            endTime = isoEndTime,
            machine = machine.value,
            project = selectedProject.id,
            reservedBy = reservedBy.value,
            reservedDate = isoDate,
            startTime = isoStartTime
        )
    }

    fun bookMachine() {
        if (reservationStatus.value is Resource.Loading)
            return
        viewModelScope.launch {
            toMachineReservationRequest()?.let { request ->
                machineRepository.reserveMachine(request).collect {
                    reservationStatus.value = it
                }
            }
        }
    }

    private fun fetchProjectList() {
        viewModelScope.launch {
            projectRepository.listProject().collect {
                val list = it.data ?: emptyList()
                projectList = list.filter { project ->
                    project.student == reservedBy.value || project.teammates.contains(reservedBy.value)
                }
            }
        }
    }
}