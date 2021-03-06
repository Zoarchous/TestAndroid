package com.example.testandroid.data.localModel.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.testandroid.data.localModel.dao.ImagesDao
import com.example.testandroid.data.localModel.dao.LocationNameDao
import com.example.testandroid.data.localModel.dao.SectionNameDao
import com.example.testandroid.domain.names.SectionNameItem
import com.example.testandroid.domain.image.ImageItem
import com.example.testandroid.domain.names.LocationNameItem

@Database(entities = [ImageItem::class, SectionNameItem::class, LocationNameItem::class],  version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun imagesDao(): ImagesDao
    abstract fun sectionNameDao(): SectionNameDao
    abstract fun locationNameDao(): LocationNameDao


    companion object {

        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {

            synchronized(this) {


                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDataBase::class.java,
                        "app_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}