package com.example.testandroid.domain

import android.app.Application
import com.example.testandroid.data.localModel.AppDataBase
import com.example.testandroid.data.localModel.LocalModel

class GetImagesListFromDatabaseUseCase(
    val localModel: LocalModel,
    private val repository: ImagesListRepository
) {
    suspend fun getImagesListFromDatabaseUseCase(): MutableList<ImageItem>{
        return repository.getImagesListFromDatabaseUseCase()
    }
}