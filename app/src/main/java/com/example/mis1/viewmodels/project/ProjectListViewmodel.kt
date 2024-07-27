package com.example.mis1.viewmodels.project

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mis1.common.searchInProperties
import com.example.mis1.model.Project
import com.example.mis1.repository.ProjectRepository
import com.example.mis1.ui.routes.ProjectTabs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProjectListViewmodel @Inject constructor(private val projectRepository: ProjectRepository) : ViewModel() {
    var visibleTabs by mutableStateOf(ProjectTabs.MY_PROJECTS)
        private set
    var projects by mutableStateOf<List<Project>>(emptyList())
        private set
    var myProjects by mutableStateOf<List<Project>>(emptyList())
        private set
    var filteredProjects by mutableStateOf<List<Project>>(emptyList())
        private set
    var filteredMyProjects by mutableStateOf<List<Project>>(emptyList())
        private set
    var searchQuery by mutableStateOf("")
        private set

    private var userId by mutableStateOf<Int?>(null)

    init {
        fetchProjects()
    }

    fun showExploreProjectsTab(){
        visibleTabs = ProjectTabs.EXPLORE_PROJECTS
    }

    fun showMyProjectsTab(){
        visibleTabs = ProjectTabs.MY_PROJECTS
    }

    fun updateUserId(id: Int){
        userId = id
        updateMyProjects()
        updateFilteredProjects()
    }

    fun updateSearchQuery(query: String) {
        searchQuery = query
        updateFilteredProjects()
    }

    private fun updateMyProjects(){
        userId?.let { id ->
            myProjects = projects.filter { project: Project ->
                project.student == id || project.teammates.contains(id)
            }
        }
    }

    private fun updateFilteredProjects() {
        filteredProjects = if (searchQuery.isEmpty()) {
            projects
        } else {
            projects.filter { project ->
                project.searchInProperties(searchQuery)
                        || project.type?.displayName?.contains(searchQuery) ?: false
                        || project.type?.displayName?.contains(searchQuery) ?: false
            }
        }

        filteredMyProjects = if (searchQuery.isEmpty()) {
            myProjects
        } else {
            myProjects.filter { project ->
                project.searchInProperties(searchQuery)
                        || project.type?.displayName?.contains(searchQuery) ?: false
                        || project.type?.displayName?.contains(searchQuery) ?: false
            }
        }
    }

    private fun fetchProjects() {
        viewModelScope.launch {
            projectRepository.listProject().collect {
                it.data?.let { list ->
                    projects = list
                    updateMyProjects()
                    updateFilteredProjects()
                }
            }
        }
    }
}
