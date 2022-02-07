package com.example.testandroid.domain

import android.text.Editable
import androidx.lifecycle.LiveData
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testandroid.domain.ImageItem
@Entity (tableName = "section_name")
data class SectionNameItem(
    @PrimaryKey val id: Int = 1,
    val sectionName: String
)
