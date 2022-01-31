package com.example.testandroid.presentation

import androidx.lifecycle.ViewModel
import com.example.testandroid.data.ImagesListRepositoryImpl
import com.example.testandroid.domain.GetImagesListUseCase

class MainViewModel: ViewModel() {
    private val repository = ImagesListRepositoryImpl

    private val getImagesListUseCase = GetImagesListUseCase(repository)

    val imagesList = getImagesListUseCase.getImagesList()
}