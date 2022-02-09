package com.example.testandroid.data

import androidx.lifecycle.LiveData
import com.example.testandroid.data.localModel.LocalDataSource
import com.example.testandroid.domain.names.SectionNameItem
import com.example.testandroid.domain.image.ImageItem
import com.example.testandroid.domain.Repository
import com.example.testandroid.domain.names.LocationNameItem
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val localDataSource: LocalDataSource) :
    Repository {

    override suspend fun insertImage(image: ImageItem) {
        localDataSource.insertImage(image)
    }

    override suspend fun getSectionName(): SectionNameItem {
        return localDataSource.getSectionName()
    }

    override suspend fun getLocationName(): LocationNameItem {
        return localDataSource.getLocationName()
    }

    override suspend fun insertLocationName(locationNameItem: LocationNameItem) {
        localDataSource.insertLocationName(locationNameItem)
    }

    override suspend fun insertSectionName(sectionNameItem: SectionNameItem) {
        localDataSource.insertSectionName(sectionNameItem)
    }

    override suspend fun deleteLocationName() {
        localDataSource.deleteLocationName()
    }

    override suspend fun deleteSectionName() {
        localDataSource.deleteSectionName()
    }

    override suspend fun clearImagesDatabase(item: ImageItem) {
        localDataSource.clearImagesDatabase(item)
    }

    override fun getImagesList(): LiveData<MutableList<ImageItem>> {
        return localDataSource.getAllImages()
    }

}