package com.example.testandroid.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.testandroid.data.ImagesListRepositoryImpl
import com.example.testandroid.data.localModel.ImagesDao
import com.example.testandroid.domain.AddImageItemUseCase
import com.example.testandroid.domain.GetImagesListUseCase
import com.example.testandroid.domain.ImageItem

class MainViewModel (val imagesDatabase: ImagesDao, application: Application): ViewModel() {
    private val repository = ImagesListRepositoryImpl

    private val getImagesListUseCase = GetImagesListUseCase(repository)
    private val addImageItemUseCase = AddImageItemUseCase(repository)

    val imagesList = getImagesListUseCase.getImagesList()

    fun addImageItem (image: ImageItem){
        addImageItemUseCase.addImageItem(image)
        insert(image)
    }

    fun insert(image: ImageItem){
        imagesDatabase.insertImage(image)
    }

}