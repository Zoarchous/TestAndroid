package com.example.testandroid.data.localModel

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.testandroid.domain.ImageItem

@Dao
interface ImagesDao {
    @Query ("SELECT * FROM images" )
    fun getAllImages(): LiveData<List<ImageItem>>

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    @Transaction
    suspend fun insertImage (image: ImageItem)

    @Delete
    suspend fun clearImagesDatabase(item: ImageItem)
}