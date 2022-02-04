package com.example.testandroid.domain

import javax.inject.Inject

class AddImageItemUseCase @Inject constructor ( private val repository: ImagesListRepository) {
    fun addImageItem (item: ImageItem){
        repository.addImageItem(item)
    }
}