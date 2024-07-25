package com.example.mis1.ui.screens.training

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mis1.ui.composables.Filters
import com.example.mis1.ui.composables.bar.SearchBar
import com.example.mis1.ui.composables.button.TabTitle
import com.example.mis1.ui.composables.enums.TabTitleType
import com.example.mis1.ui.composables.list_item.TutorialItem
import com.example.mis1.ui.theme.Size120

@Composable
fun TrainingScreen(){
    Column {
        Spacer(modifier =Modifier.height(Size120))
        val value = remember{ mutableStateOf("") }
        Row {
            SearchBar(
                value = value,
                onSearchTextChanged = {  },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Filters()
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier.weight(1f)){
                TabTitle(
                    type = TabTitleType.Training,
                    text = "Tutorials",
                    isActive = true
//                isActive = viewModel.visibleTab.value == InventoryTabs.Machine,
//                onClick = viewModel::showMachineTab
                )
            }
            Box(modifier = Modifier.weight(1f)){
                TabTitle(
                    type = TabTitleType.Training,
                    text = "Workshop",
//                isActive = viewModel.visibleTab.value == InventoryTabs.Machine,
//                onClick = viewModel::showMachineTab
                )
            }
            Box(modifier = Modifier.weight(1f)){
                TabTitle(
                    type = TabTitleType.Training,
                    text = "My Learning",
//                isActive = viewModel.visibleTab.value == InventoryTabs.Machine,
//                onClick = viewModel::showMachineTab
                )
            }

        }


        Spacer(modifier =Modifier.height(Size120))
        Column(modifier = Modifier.verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(Size120)) {
            for (i in 1..10)
                TutorialItem()
        }

    }
}