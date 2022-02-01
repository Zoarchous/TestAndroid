package com.example.testandroid.data.localModel

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.testandroid.domain.ImageItem
import kotlinx.coroutines.selects.select

@Dao
interface ImagesDao {
    @Query ("SELECT * FROM images" )
    fun getAllImages(): LiveData<List<ImageItem>>
    @Insert
    fun insertImage (image: ImageItem)
    @Query ("DELETE FROM images")
    fun clearImagesDatabase()
}