package com.example.testandroid.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.testandroid.domain.ImageItem

class ImageItemDiffCallback: DiffUtil.ItemCallback<ImageItem>() {
    override fun areItemsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean {
        return  oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean {
        return oldItem == newItem
    }

}