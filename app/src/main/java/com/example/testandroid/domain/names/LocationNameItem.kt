package com.example.testandroid.domain.names

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "location_name")
data class LocationNameItem(
    @PrimaryKey val id: Int = 1,
    val locationName: String
)