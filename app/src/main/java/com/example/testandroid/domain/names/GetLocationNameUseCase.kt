package com.example.testandroid.domain.names

import com.example.testandroid.domain.Repository
import javax.inject.Inject

class GetLocationNameUseCase @Inject constructor(private val repository: Repository) {
    suspend fun getLocationName(): LocationNameItem {
        return repository.getLocationName()
    }
}