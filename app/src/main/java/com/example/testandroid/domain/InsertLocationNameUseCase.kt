package com.example.testandroid.domain

import javax.inject.Inject

class InsertLocationNameUseCase @Inject constructor(private val repository: ImagesListRepository) {
    suspend fun insertLocationName(locationNameItem: LocationNameItem){
        repository.insertLocationName(locationNameItem)
    }
}