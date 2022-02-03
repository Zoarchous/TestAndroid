package com.example.testandroid.data.localModel

import android.app.Application
import com.example.testandroid.domain.ImageItem

class LocalModel (application: Application) {
    private val database = AppDataBase.getInstance(application)

    suspend fun getAllImages(): MutableList<ImageItem>{
        return database.imagesDao().getAllImages()
    }
}