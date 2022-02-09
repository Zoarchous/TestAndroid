package com.example.testandroid.domain.names

import com.example.testandroid.domain.Repository
import javax.inject.Inject

class InsertLocationNameUseCase @Inject constructor(private val repository: Repository) {
    suspend fun insertLocationName(locationNameItem: LocationNameItem){
        repository.insertLocationName(locationNameItem)
    }
}