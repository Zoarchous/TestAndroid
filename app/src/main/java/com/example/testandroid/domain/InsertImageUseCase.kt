package com.example.testandroid.domain

import javax.inject.Inject

class InsertImageUseCase @Inject constructor ( private val repository: ImagesListRepository) {
    suspend fun insertImage(image: ImageItem){
        repository.insertImage(image)
    }
}