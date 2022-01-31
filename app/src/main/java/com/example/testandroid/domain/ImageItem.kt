package com.example.testandroid.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "images")
data class ImageItem(
    @PrimaryKey var id: Int = UNDEFINED_ID,
    var photo: String
){
    companion object {
        const val UNDEFINED_ID = -1
    }
}
