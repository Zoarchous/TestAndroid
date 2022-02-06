package com.example.testandroid.data.localModel

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.testandroid.domain.ActivityItem
import com.example.testandroid.domain.ImageItem

@Database(entities = [ImageItem::class, ActivityItem::class],  version = 4)
abstract class AppDataBase : RoomDatabase() {
    abstract fun imagesDao(): ImagesDao
    abstract fun namesDao(): NamesDao

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