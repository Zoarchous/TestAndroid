package com.example.testandroid.domain

import javax.inject.Inject

class GetLocationNameUseCase @Inject constructor(private val repository: ImagesListRepository) {
    suspend fun getLocationName(): LocationNameItem{
        return repository.getLocationName()
    }
}