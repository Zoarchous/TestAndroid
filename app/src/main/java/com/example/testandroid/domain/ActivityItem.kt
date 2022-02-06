package com.example.testandroid.domain

import android.text.Editable
import androidx.lifecycle.LiveData
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testandroid.domain.ImageItem
@Entity (tableName = "names")
data class ActivityItem(
    @PrimaryKey val sectionName: String,
    val locationName: String?
)
