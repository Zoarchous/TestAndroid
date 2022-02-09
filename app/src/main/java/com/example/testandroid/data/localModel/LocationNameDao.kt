package com.example.testandroid.data.localModel

import androidx.room.*
import com.example.testandroid.domain.names.LocationNameItem

@Dao
interface LocationNameDao {
    @Query ("SELECT * FROM location_name")
    suspend fun getLocationName(): LocationNameItem

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun insertLocationName(locationNameItem: LocationNameItem)

    @Query ("DELETE FROM location_name")
    suspend fun deleteLocationName()
}