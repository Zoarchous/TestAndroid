package com.example.testandroid.domain

import javax.inject.Inject

class ClearSelectedImagesUseCase @Inject constructor(private val repository: ImagesListRepository) {
    suspend fun clearSelectedImages(item: ImageItem){
        repository.clearImagesDatabase(item)
    }
}