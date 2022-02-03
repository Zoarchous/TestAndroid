package com.example.testandroid.presentation

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.testandroid.data.ImagesListRepositoryImpl
import com.example.testandroid.data.localModel.ImagesDao
import com.example.testandroid.domain.AddImageItemUseCase
import com.example.testandroid.domain.GetImagesListUseCase
import com.example.testandroid.domain.ImageItem
import com.example.testandroid.domain.InsertImageUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel (repository: ImagesListRepositoryImpl): ViewModel() {

    val scope = CoroutineScope(Dispatchers.IO)

    private val getImagesListUseCase = GetImagesListUseCase(repository)
    private val addImageItemUseCase = AddImageItemUseCase(repository)
    private val insertImageUseCase = InsertImageUseCase(repository)

    val imagesList = getImagesListUseCase.getImagesList()



    suspend fun addImageItem (image: ImageItem){
        scope.launch {
            addImageItemUseCase.addImageItem(image)
            insertImageUseCase.insertImage(image)
        }

    }


}