package com.example.testandroid.data.localModel

import androidx.room.*
import com.example.testandroid.domain.SectionNameItem

@Dao
interface SectionNameDao {
    @Query ("SELECT * FROM section_name")
    suspend fun getSectionName(): SectionNameItem

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun insertSectionName(sectionNameItem: SectionNameItem)

    @Query("DELETE FROM section_name")
    suspend fun deleteSectionName()
}