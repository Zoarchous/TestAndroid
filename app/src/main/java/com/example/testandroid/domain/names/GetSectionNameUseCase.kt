package com.example.testandroid.domain.names

import com.example.testandroid.domain.Repository
import javax.inject.Inject

class GetSectionNameUseCase @Inject constructor(private val repository: Repository) {
    suspend fun getSectionName(): SectionNameItem {
        return repository.getSectionName()
    }
}