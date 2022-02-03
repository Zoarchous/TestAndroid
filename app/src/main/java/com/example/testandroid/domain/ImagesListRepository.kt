package com.example.testandroid.domain

import androidx.lifecycle.LiveData
import com.example.testandroid.data.localModel.LocalDataSource
import javax.inject.Inject

interface ImagesListRepository{

    fun getImagesList ():LiveData<List<ImageItem>>

    fun addImageItem(item: ImageItem)

    suspend fun insertImage(image: ImageItem)
}