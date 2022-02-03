package com.example.testandroid.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testandroid.data.ImagesListRepositoryImpl
import com.example.testandroid.data.localModel.ImagesDao
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(val repository: ImagesListRepositoryImpl): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}