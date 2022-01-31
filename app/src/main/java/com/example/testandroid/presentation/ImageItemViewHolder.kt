package com.example.testandroid.presentation

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.testandroid.R

class ImageItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val photo: ImageView = view.findViewById(R.id.image_item)
}