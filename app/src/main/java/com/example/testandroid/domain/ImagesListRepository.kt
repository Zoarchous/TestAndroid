package com.example.testandroid.domain

import androidx.lifecycle.LiveData
import com.example.testandroid.data.localModel.LocalDataSource
import javax.inject.Inject

interface ImagesListRepository{

    fun getImagesList ():LiveData<List<ImageItem>>

    suspend fun insertImage(image: ImageItem)
}