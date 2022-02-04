package com.example.testandroid.domain

import androidx.lifecycle.LiveData
import com.example.testandroid.data.localModel.ImagesDao
import javax.inject.Inject

class GetImagesListUseCase @Inject constructor (private val repository: ImagesListRepository) {
    fun getImagesList():LiveData<List<ImageItem>>{
        return repository.getImagesList()
    }
}