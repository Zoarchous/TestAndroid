package com.example.testandroid.data

import androidx.lifecycle.LiveData
import com.example.testandroid.data.localModel.LocalDataSource
import com.example.testandroid.domain.ActivityItem
import com.example.testandroid.domain.ImageItem
import com.example.testandroid.domain.ImagesListRepository
import javax.inject.Inject

class ImagesListRepositoryImpl @Inject constructor(private val localDataSource: LocalDataSource) :
    ImagesListRepository {

    override suspend fun insertImage(image: ImageItem) {
        localDataSource.insertImage(image)
    }

    override suspend fun getNames(): ActivityItem {
        return localDataSource.getNames()
    }

    override suspend fun insertNames(activityItem: ActivityItem) {
        localDataSource.insertNames(activityItem)
    }

    override suspend fun delete(activityItem: ActivityItem) {
        localDataSource.delete(activityItem)
    }

    override fun getImagesList(): LiveData<List<ImageItem>> {
        return localDataSource.getAllImages()
    }

}