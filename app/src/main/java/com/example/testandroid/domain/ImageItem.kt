package com.example.testandroid.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "images")
data class ImageItem(
    var photo: String,
    @PrimaryKey var id: Int = UNDEFINED_ID,
){
    companion object {
        const val UNDEFINED_ID = -1
    }
}
