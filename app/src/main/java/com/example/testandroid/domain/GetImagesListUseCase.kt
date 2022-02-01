package com.example.testandroid.domain

import androidx.lifecycle.LiveData
import com.example.testandroid.data.localModel.ImagesDao

class GetImagesListUseCase (private val repository: ImagesListRepository) {
    fun getImagesList():LiveData<List<ImageItem>>{
        return repository.getImagesList()
    }
}