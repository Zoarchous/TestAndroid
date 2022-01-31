package com.example.testandroid.domain

class AddImageItemUseCase (private val repository: ImagesListRepository) {
    fun addImageItem (item: ImageItem){
        repository.addImageItem(item)
    }
}