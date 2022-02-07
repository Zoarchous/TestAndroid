package com.example.testandroid.domain

import javax.inject.Inject

class DeleteSectionNameUseCase @Inject constructor(private val repository: ImagesListRepository) {
    suspend fun deleteSectionName(){
        repository.deleteSectionName()
    }
}