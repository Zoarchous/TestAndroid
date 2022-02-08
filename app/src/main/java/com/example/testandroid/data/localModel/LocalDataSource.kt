package com.example.testandroid.data.localModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testandroid.domain.SectionNameItem
import com.example.testandroid.domain.ImageItem
import com.example.testandroid.domain.LocationNameItem
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class LocalDataSource @Inject constructor(@ApplicationContext context: Context) {
    private val dataBase = AppDataBase.getInstance(context)

    fun getAllImages(): LiveData<MutableList<ImageItem>> {
        return dataBase.imagesDao().getAllImages()
    }

    suspend fun insertImage (image: ImageItem){
        dataBase.imagesDao().insertImage(image)
    }

    suspend fun getSectionName(): SectionNameItem{
        return dataBase.sectionNameDao().getSectionName()
    }

    suspend fun getLocationName(): LocationNameItem {
        return dataBase.locationNameDao().getLocationName()
    }

    suspend fun insertLocationName(locationNameItem: LocationNameItem){
        dataBase.locationNameDao().insertLocationName(locationNameItem)
    }

    suspend fun insertSectionName (sectionNameItem: SectionNameItem){
        dataBase.sectionNameDao().insertSectionName(sectionNameItem)
    }

    suspend fun deleteSectionName(){
        dataBase.sectionNameDao().deleteSectionName()
    }

    suspend fun deleteLocationName(){
        dataBase.locationNameDao().deleteLocationName()
    }

    suspend fun clearImagesDatabase(item: ImageItem){
        dataBase.imagesDao().clearImagesDatabase(item)
    }
}