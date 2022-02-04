package com.example.testandroid.data.localModel

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.testandroid.domain.ImageItem
import kotlinx.coroutines.selects.select

@Dao
interface ImagesDao {
    @Query ("SELECT * FROM images" )
    fun getAllImages(): LiveData<List<ImageItem>>

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    @Transaction
    suspend fun insertImage (image: ImageItem)

    @Query ("DELETE FROM images")
    suspend fun clearImagesDatabase()
}