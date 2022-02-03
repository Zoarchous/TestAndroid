package com.example.testandroid.domain

class InsertImageUseCase (private val repository: ImagesListRepository) {
    suspend fun insertImage(image: ImageItem){
        repository.insertImage(image)
    }
}