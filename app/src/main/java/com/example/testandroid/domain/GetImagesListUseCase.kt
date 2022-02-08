package com.example.testandroid.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testandroid.data.localModel.ImagesDao
import javax.inject.Inject

class GetImagesListUseCase @Inject constructor (private val repository: ImagesListRepository) {
    fun getImagesList(): LiveData<MutableList<ImageItem>> {
        return repository.getImagesList()
    }
}