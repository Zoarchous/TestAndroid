package com.example.testandroid.data.localModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import com.example.testandroid.domain.ImageItem
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class LocalDataSource @Inject constructor(@ApplicationContext context: Context) {
    private val dataBase = AppDataBase.getInstance(context)

    fun getAllImages(): LiveData<List<ImageItem>>{
        return dataBase.imagesDao().getAllImages()
    }

    suspend fun insertImage (image: ImageItem){
        dataBase.imagesDao().insertImage(image)
    }
}