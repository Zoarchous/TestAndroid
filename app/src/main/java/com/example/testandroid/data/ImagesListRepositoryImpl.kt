package com.example.testandroid.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testandroid.data.localModel.LocalDataSource
import com.example.testandroid.domain.ImageItem
import com.example.testandroid.domain.ImagesListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ImagesListRepositoryImpl @Inject constructor(val localDataSource: LocalDataSource) :
    ImagesListRepository {
//    private val imagesList = sortedSetOf<ImageItem>({ o1, o2 -> o1.id.compareTo(o2.id) })
    private var autoIncrementId = 0
    private var imagesListLD = MutableLiveData<List<ImageItem>>()
    val scope = CoroutineScope(Dispatchers.IO)




    override suspend fun insertImage(image: ImageItem) {
        localDataSource.insertImage(image)
    }

    override fun getImagesList(): LiveData<List<ImageItem>> {

        return localDataSource.getAllImages()
    }

//    private fun updateList() {
//        imagesListLD.postValue(imagesList.toList())
//    }
}