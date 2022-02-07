package com.example.testandroid.domain

import javax.inject.Inject

class DeleteLocationNameUseCase @Inject constructor(private val repository: ImagesListRepository) {
    suspend fun deleteLocationName (){
        repository.deleteLocationName()
    }
}