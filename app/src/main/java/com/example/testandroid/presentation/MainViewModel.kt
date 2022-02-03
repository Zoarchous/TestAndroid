package com.example.testandroid.presentation

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.testandroid.data.ImagesListRepositoryImpl
import com.example.testandroid.data.localModel.AppDataBase
import com.example.testandroid.data.localModel.ImagesDao
import com.example.testandroid.domain.AddImageItemUseCase
import com.example.testandroid.domain.GetImagesListUseCase
import com.example.testandroid.domain.ImageItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel (application: Application): ViewModel() {
    private val repository = ImagesListRepositoryImpl
    private val db = AppDataBase.getInstance(application)

    private val scope = CoroutineScope(Dispatchers.IO)

    private val getImagesListUseCase = GetImagesListUseCase(repository)
    private val addImageItemUseCase = AddImageItemUseCase(repository)

    val imagesList = getImagesListUseCase.getImagesList()



    suspend fun addImageItem (image: ImageItem){
        scope.launch {
            addImageItemUseCase.addImageItem(image)
            insert(image)
        }

    }

    private suspend fun insert(image: ImageItem){
        db.imagesDao().insertImage(image)
    }

}