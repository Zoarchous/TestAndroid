package com.example.testandroid.domain.image

import com.example.testandroid.domain.Repository
import javax.inject.Inject

class ClearSelectedImagesUseCase @Inject constructor(private val repository: Repository) {
    suspend fun clearSelectedImages(item: ImageItem){
        repository.clearImagesDatabase(item)
    }
}