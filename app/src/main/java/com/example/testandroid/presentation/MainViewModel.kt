package com.example.testandroid.presentation

import android.widget.EditText
import androidx.lifecycle.ViewModel
import com.example.testandroid.data.ImagesListRepositoryImpl
import com.example.testandroid.domain.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.lifecycle.MutableLiveData




class MainViewModel(repository: ImagesListRepositoryImpl) : ViewModel() {

    val scope = CoroutineScope(Dispatchers.IO)

    private val getImagesListUseCase = GetImagesListUseCase(repository)

    private val insertImageUseCase = InsertImageUseCase(repository)

    private val getSectionNameUseCase = GetSectionNameUseCase(repository)

    private val getLocationNameUseCase = GetLocationNameUseCase(repository)

    private val insertLocationNameUseCase = InsertLocationNameUseCase(repository)

    private val insertSectionNameUseCase = InsertSectionNameUseCase(repository)

    private val clearSelectedImagesUseCase = ClearSelectedImagesUseCase(repository)

    val imagesList = getImagesListUseCase.getImagesList()

    var mutableLiveData = MutableLiveData<String>()

    // create set text method
    fun setText(s: String) {
        // set value
        mutableLiveData.value = s
    }

    // create get text method
    fun getText(): MutableLiveData<String>? {
        return mutableLiveData
    }


    fun deleteSelected(item: ImageItem){
        scope.launch {
            clearSelectedImagesUseCase.clearSelectedImages(item)
        }
    }

    suspend fun addImageItem(image: ImageItem) {
        scope.launch {
            insertImageUseCase.insertImage(image)
        }
    }

    suspend fun insertSectionName(sectionName: String){
        val name = SectionNameItem(1, sectionName)
        insertSectionNameUseCase.insertSectionName(name)
    }
    suspend fun insertLocationName(locationName: String){
        val name = LocationNameItem(1, locationName)
        insertLocationNameUseCase.insertLocationName(name)
    }

    suspend fun setNames(view1: EditText, view2: EditText){
        val item1 = getSectionNameUseCase.getSectionName()
        val item2 = getLocationNameUseCase.getLocationName()

        if (item1 != null){
            view1.setText(item1.sectionName)
        }

        if (item2 != null){
            view2.setText(item2.locationName)
        }
    }
}