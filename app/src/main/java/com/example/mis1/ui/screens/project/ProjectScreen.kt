package com.example.mis1.ui.screens.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mis1.R
import com.example.mis1.ui.composables.Filters
import com.example.mis1.ui.composables.bar.SearchBar
import com.example.mis1.ui.composables.button.TabTitle
import com.example.mis1.ui.composables.list_item.ProjectItem
import com.example.mis1.ui.routes.ProjectTabs
import com.example.mis1.ui.routes.Screens
import com.example.mis1.ui.theme.M
import com.example.mis1.ui.theme.SAccentSource
import com.example.mis1.ui.theme.Size120
import com.example.mis1.viewmodels.AppViewmodel
import com.example.mis1.viewmodels.project.ProjectListViewmodel

@Composable
fun ProjectScreen(
    viewModel: ProjectListViewmodel = hiltViewModel(),
    appViewModel: AppViewmodel,
    navController: NavController
) {
    Box(modifier = Modifier.fillMaxSize()) {
        LaunchedEffect(key1 = appViewModel.user) {
            appViewModel.user?.let {
                viewModel.updateUserId(appViewModel.user!!.id)
            }
        }
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TabTitle(
                    text = "  My Projects  ",
                    isActive = viewModel.visibleTabs == ProjectTabs.MY_PROJECTS,
                    onClick = viewModel::showMyProjectsTab
                )
                TabTitle(
                    text = "  Explore Projects  ",
                    isActive = viewModel.visibleTabs == ProjectTabs.EXPLORE_PROJECTS,
                    onClick = viewModel::showExploreProjectsTab
                )
            }
            Spacer(modifier = Modifier.height(M))
            Row {
                SearchBar(
                    modifier = Modifier.weight(1f),
                    value = viewModel.searchQuery,
                    onSearchTextChanged = viewModel::updateSearchQuery
                )
                Spacer(modifier = Modifier.width(8.dp))
                Filters()
            }
            Spacer(modifier = Modifier.height(8.dp))
            LazyColumn(verticalArrangement = Arrangement.spacedBy(M)) {
                when (viewModel.visibleTabs) {
                    ProjectTabs.EXPLORE_PROJECTS -> items(viewModel.filteredProjects) { item ->
                        ProjectItem(item)
                    }

                    ProjectTabs.MY_PROJECTS -> items(viewModel.filteredMyProjects) { item ->
                        ProjectItem(item)
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(10.dp)
        ) {
            FloatingActionButton(
                modifier = Modifier.padding(Size120),
                onClick = {
                    navController.navigate(Screens.AddProject.path) {
                        launchSingleTop = true
                    }
                },
                shape = CircleShape,
                containerColor = SAccentSource
            ) {
                Image(
                    modifier = Modifier
                        .height(20.dp)
                        .width(20.dp),
                    painter = painterResource(id = R.drawable.add), contentDescription = "add"
                )
            }
        }

    }
}