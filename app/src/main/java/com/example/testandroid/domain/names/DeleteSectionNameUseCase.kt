package com.example.testandroid.domain.names

import com.example.testandroid.domain.Repository
import javax.inject.Inject

class DeleteSectionNameUseCase @Inject constructor(private val repository: Repository) {
    suspend fun deleteSectionName(){
        repository.deleteSectionName()
    }
}