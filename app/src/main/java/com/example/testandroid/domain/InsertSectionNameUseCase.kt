package com.example.testandroid.domain

import javax.inject.Inject

class InsertSectionNameUseCase @Inject constructor(private val repository: ImagesListRepository) {
    suspend fun insertSectionName(sectionNameItem: SectionNameItem){
        repository.insertSectionName(sectionNameItem)
    }
}