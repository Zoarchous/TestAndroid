package com.example.testandroid.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.testandroid.R

import com.example.testandroid.domain.ImageItem
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropSquareTransformation


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
            .transform(CropSquareTransformation())
            .into(viewHolder.photo)
    }


}