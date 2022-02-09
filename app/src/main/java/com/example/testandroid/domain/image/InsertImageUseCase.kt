package com.example.testandroid.domain.image

import com.example.testandroid.domain.Repository
import javax.inject.Inject

class InsertImageUseCase @Inject constructor ( private val repository: Repository) {
    suspend fun insertImage(image: ImageItem){
        repository.insertImage(image)
    }
}