package com.example.mis1.repository

import com.example.mis1.common.Resource
import com.example.mis1.data.remote.training.TrainingApi
import com.example.mis1.data.remote.training.dto.TutorialDto
import com.example.mis1.model.Tutorial
import com.example.mis1.model.Video
import kotlinx.coroutines.flow.Flow

class TrainingRepository(
    private val api: TrainingApi,
    private val apiCallRepository: ApiCallRepository
) {
    suspend fun searchUser(query: String) = apiCallRepository.protectedApiCall("Unable to fetch users"){
        api.searchUser(query)
    }

    suspend fun tutorialList(): Flow<Resource<List<Tutorial>>> = apiCallRepository.protectedApiCall(errorMessage = "Unable to fetch tutorial list"){
        val response = api.tutorialList()
        val result = mutableListOf<Tutorial>()
        response.forEach {
            try {
                result.add(resolveTutorial(it))
                emit(Resource.Success(result))
            }
            catch (_:Exception){}
        }
        result
    }
    private suspend fun resolveTutorial(tutorialDto: TutorialDto):Tutorial{
        val videos=mutableListOf<Video>()
        videos.addAll(tutorialDto.videos.map {
            val response = api.videoDetail(it.video)
            val result = Video(
                college = response.college,
                description = response.description,
                title = response.title,
                id = response.id,
                link = response.link,
                videoLength = response.videoLength?:0,
                order = it.order
            )
            result
        })
        videos.sortedBy { it.order }
        val tags = mutableListOf<String>()
        if (tutorialDto.relatedEquipments.isNotEmpty()) tags.add("Equipment")
        if (tutorialDto.relatedMachines.isNotEmpty()) tags.add("Machine")
        if (tutorialDto.relatedInventory.isNotEmpty()) tags.add("Inventory")

        val totalLength = videos.sumOf { it.videoLength }

        return Tutorial(
            college = tutorialDto.college,
            description = tutorialDto.description,
            id = tutorialDto.id,
            image = tutorialDto.image,
            name = tutorialDto.name,
            relatedEquipments = tutorialDto.relatedEquipments,
            relatedInventory = tutorialDto.relatedInventory,
            relatedMachines = tutorialDto.relatedMachines,
            videos = videos,
            totalLength = totalLength,
            tags = tags
        )
    }

    suspend fun workshopList() = apiCallRepository.protectedApiCall(errorMessage = "Unable to fetch workshop list"){
        api.workshopList()
    }
}