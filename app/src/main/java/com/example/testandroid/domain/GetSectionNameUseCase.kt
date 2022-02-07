package com.example.testandroid.domain

import javax.inject.Inject

class GetSectionNameUseCase @Inject constructor(private val repository: ImagesListRepository) {
    suspend fun getSectionName(): SectionNameItem{
        return repository.getSectionName()
    }
}