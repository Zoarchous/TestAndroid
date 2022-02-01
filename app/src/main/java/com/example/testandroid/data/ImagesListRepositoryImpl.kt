package com.example.testandroid.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testandroid.domain.ImageItem
import com.example.testandroid.domain.ImagesListRepository

object ImagesListRepositoryImpl: ImagesListRepository {
    private val imagesList = sortedSetOf<ImageItem>({ o1, o2 -> o1.id.compareTo(o2.id)})
    private var autoIncrementId = 0
    private val imagesListLD = MutableLiveData<List<ImageItem>>()


    override fun addImageItem(item: ImageItem) {
        if (item.id == ImageItem.UNDEFINED_ID){
            item.id = autoIncrementId++
        }
        imagesList.add(item)
        updateList()
    }

    override fun getImagesList(): LiveData<List<ImageItem>> {
        return imagesListLD
    }

    private fun updateList(){
        imagesListLD.postValue(imagesList.toList())
    }
}