package com.example.testandroid.domain

import javax.inject.Inject

class GetNamesUseCase @Inject constructor(private val repository: ImagesListRepository) {
    suspend fun getNames(): ActivityItem{
        return repository.getNames()
    }
}