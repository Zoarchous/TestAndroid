package com.example.testandroid.data

import androidx.lifecycle.LiveData
import com.example.testandroid.data.localModel.LocalDataSource
import com.example.testandroid.domain.ImageItem
import com.example.testandroid.domain.ImagesListRepository
import javax.inject.Inject

class ImagesListRepositoryImpl @Inject constructor(val localDataSource: LocalDataSource) :
    ImagesListRepository {

    override suspend fun insertImage(image: ImageItem) {
        localDataSource.insertImage(image)
    }

    override fun getImagesList(): LiveData<List<ImageItem>> {
        return localDataSource.getAllImages()
    }

}