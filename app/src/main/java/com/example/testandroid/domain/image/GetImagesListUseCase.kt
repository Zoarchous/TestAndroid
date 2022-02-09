package com.example.testandroid.domain.image

import androidx.lifecycle.LiveData
import com.example.testandroid.domain.Repository
import javax.inject.Inject

class GetImagesListUseCase @Inject constructor (private val repository: Repository) {
    fun getImagesList(): LiveData<MutableList<ImageItem>> {
        return repository.getImagesList()
    }
}