package com.example.testandroid.domain

data class ImageItem(
    var id: Int = UNDEFINED_ID,
    var photo: String
){
    companion object {
        const val UNDEFINED_ID = -1
    }
}
