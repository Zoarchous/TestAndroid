package com.example.testandroid.domain.names

import com.example.testandroid.domain.Repository
import javax.inject.Inject

class DeleteLocationNameUseCase @Inject constructor(private val repository: Repository) {
    suspend fun deleteLocationName (){
        repository.deleteLocationName()
    }
}