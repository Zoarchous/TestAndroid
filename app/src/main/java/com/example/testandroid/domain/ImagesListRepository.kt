package com.example.testandroid.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface ImagesListRepository{

    fun getImagesList (): LiveData<MutableList<ImageItem>>

    suspend fun insertImage(image: ImageItem)

    suspend fun getSectionName(): SectionNameItem

    suspend fun getLocationName(): LocationNameItem

    suspend fun insertLocationName(locationNameItem: LocationNameItem)

    suspend fun insertSectionName(sectionNameItem: SectionNameItem)

    suspend fun deleteLocationName()

    suspend fun deleteSectionName()

    suspend fun clearImagesDatabase(item: ImageItem)
}