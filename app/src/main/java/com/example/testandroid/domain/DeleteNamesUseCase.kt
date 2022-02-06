package com.example.testandroid.domain

import javax.inject.Inject

class DeleteNamesUseCase @Inject constructor(private val repository: ImagesListRepository) {
    suspend fun delete(activityItem: ActivityItem){
        repository.delete(activityItem)
    }
}