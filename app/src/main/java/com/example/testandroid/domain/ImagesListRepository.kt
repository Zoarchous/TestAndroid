package com.example.testandroid.domain

import androidx.lifecycle.LiveData

interface ImagesListRepository{

    fun getImagesList ():LiveData<List<ImageItem>>

    suspend fun insertImage(image: ImageItem)

    suspend fun getSectionName(): SectionNameItem

    suspend fun getLocationName(): LocationNameItem

    suspend fun insertLocationName(locationNameItem: LocationNameItem)

    suspend fun insertSectionName(sectionNameItem: SectionNameItem)

    suspend fun deleteLocationName()

    suspend fun deleteSectionName()
}