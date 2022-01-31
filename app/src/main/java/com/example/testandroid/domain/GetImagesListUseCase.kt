package com.example.testandroid.domain

import androidx.lifecycle.LiveData

class GetImagesListUseCase (private val repository: ImagesListRepository) {
    fun getImagesList():LiveData<List<ImageItem>>{
        return repository.getImagesList()
    }
}