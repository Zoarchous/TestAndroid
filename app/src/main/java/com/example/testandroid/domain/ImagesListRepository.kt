package com.example.testandroid.domain

import androidx.lifecycle.LiveData

interface ImagesListRepository {

    fun getImagesList ():LiveData<List<ImageItem>>

    fun addImageItem(item: ImageItem)
}