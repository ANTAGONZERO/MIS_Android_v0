package com.example.mis1.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mis1.data.remote.project.dto.Project
import com.example.mis1.repository.ProjectRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProjectListViewModel @Inject constructor(private val projectRepository: ProjectRepository) : ViewModel() {
    var projects by mutableStateOf<List<Project>>(emptyList())
        private set

    init {
        fetchProjects()
    }
    private fun fetchProjects() {
        viewModelScope.launch {
            projectRepository.listProject().collect{
                it.data?.let { list ->
                    projects = list
                }
            }
        }
    }
}
