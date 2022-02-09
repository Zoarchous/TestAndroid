package com.example.testandroid.domain.names

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "section_name")
data class SectionNameItem(
    @PrimaryKey val id: Int = 1,
    val sectionName: String
)
