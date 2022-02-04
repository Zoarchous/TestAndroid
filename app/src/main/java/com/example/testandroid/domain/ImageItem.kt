package com.example.testandroid.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "images")
data class ImageItem(
    var photo: String,
    @PrimaryKey (autoGenerate = true) var id: Int = 0
){
//    companion object {
//        const val UNDEFINED_ID = -1
//    }
}
