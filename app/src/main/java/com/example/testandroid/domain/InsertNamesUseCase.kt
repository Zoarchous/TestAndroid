package com.example.testandroid.domain

import javax.inject.Inject

class InsertNamesUseCase @Inject constructor(private val repository: ImagesListRepository) {
    suspend fun insertNames(activityItem: ActivityItem){
        repository.insertNames(activityItem)
    }
}