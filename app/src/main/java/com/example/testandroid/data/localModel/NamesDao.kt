package com.example.testandroid.data.localModel

import androidx.room.*
import com.example.testandroid.domain.ActivityItem

@Dao
interface NamesDao {
    @Query ("SELECT * FROM NAMES")
    suspend fun getNames(): ActivityItem

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun insertNames(activityItem: ActivityItem)

    @Delete
    suspend fun delete(activityItem: ActivityItem)
}