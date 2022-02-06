package com.example.testandroid.presentation

import android.widget.EditText
import androidx.lifecycle.ViewModel
import com.example.testandroid.data.ImagesListRepositoryImpl
import com.example.testandroid.domain.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(repository: ImagesListRepositoryImpl) : ViewModel() {

    val scope = CoroutineScope(Dispatchers.IO)

    private val getImagesListUseCase = GetImagesListUseCase(repository)

    private val insertImageUseCase = InsertImageUseCase(repository)

    private val getNamesUseCase = GetNamesUseCase(repository)

    private val insertNamesUseCase = InsertNamesUseCase(repository)

    private val deleteNamesUseCase = DeleteNamesUseCase(repository)

    val imagesList = getImagesListUseCase.getImagesList()

    lateinit var names: ActivityItem

    suspend fun getNames(): ActivityItem{
        return getNamesUseCase.getNames().also { names = it }
    }

    suspend fun addImageItem(image: ImageItem) {
        scope.launch {
            insertImageUseCase.insertImage(image)
        }
    }

    suspend fun deleteNames(activityItem: ActivityItem){
        scope.launch {
            deleteNamesUseCase.delete(activityItem)
        }
    }

    suspend fun insertNames(activityItem: ActivityItem){
        scope.launch {
            insertNamesUseCase.insertNames(activityItem)
        }
    }

    fun setNames(view1: EditText, view2: EditText){
        scope.launch {
            val item = getNames()
            if (item != null){
                view1.setText(item.sectionName)
                view2.setText(item.locationName)
            }
        }
    }
}