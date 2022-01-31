package com.example.testandroid.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.testandroid.R

import com.example.testandroid.domain.ImageItem
import com.squareup.picasso.Picasso

class RecyclerViewAdapter :
ListAdapter<ImageItem, ImageItemViewHolder>(ImageItemDiffCallback()){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.images_item,
            parent,
            false
        )
        return ImageItemViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ImageItemViewHolder, position: Int) {
        val imageItem = getItem(position)
        Picasso.get().apply { isLoggingEnabled = true }
            .load(imageItem.photo)
            .placeholder(R.drawable.ic_launcher_background)
            .into(viewHolder.photo)
    }


}