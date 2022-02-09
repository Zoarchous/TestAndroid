package com.example.testandroid.domain.image

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "images")
data class ImageItem(
    var photo: String,
    @PrimaryKey (autoGenerate = true) var id: Int = 0
){
}
