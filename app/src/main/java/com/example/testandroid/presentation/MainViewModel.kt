package com.example.testandroid.presentation

import androidx.lifecycle.ViewModel
import com.example.testandroid.data.ImagesListRepositoryImpl
import com.example.testandroid.domain.AddImageItemUseCase
import com.example.testandroid.domain.GetImagesListUseCase
import com.example.testandroid.domain.ImageItem

class MainViewModel: ViewModel() {
    private val repository = ImagesListRepositoryImpl

    private val getImagesListUseCase = GetImagesListUseCase(repository)
    private val addImageItemUseCase = AddImageItemUseCase(repository)

    val imagesList = getImagesListUseCase.getImagesList()

    fun addImageItem (image: ImageItem){
        addImageItemUseCase.addImageItem(image)
    }

}