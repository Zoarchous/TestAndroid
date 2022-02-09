package com.example.testandroid.domain.names

import com.example.testandroid.domain.Repository
import javax.inject.Inject

class InsertSectionNameUseCase @Inject constructor(private val repository: Repository) {
    suspend fun insertSectionName(sectionNameItem: SectionNameItem){
        repository.insertSectionName(sectionNameItem)
    }
}