package com.example.testandroid.domain

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.testandroid.data.localModel.LocalModel

interface ImagesListRepository {

    fun getImagesList ():LiveData<List<ImageItem>>

    fun addImageItem(item: ImageItem)

    suspend fun getImagesListFromDatabaseUseCase(): MutableList<ImageItem> {
        val localModel = LocalModel(application = Application())
        return localModel.getAllImages()
    }
}