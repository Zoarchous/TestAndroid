package com.example.testandroid.presentation

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.testandroid.R
import com.example.testandroid.domain.ImageItem
import java.net.URI

const val REQUEST_CODE = 100
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.imagesList.observe(this){
            recyclerViewAdapter.submitList(it)
        }
        val addButton = findViewById<Button>(R.id.add_image_button)

        addButton.setOnClickListener {
            val galleryIntent = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.INTERNAL_CONTENT_URI
            )
            startActivityForResult(galleryIntent, REQUEST_CODE)
        }

    }
    private fun setupRecyclerView() {
        val rvImageList = findViewById<RecyclerView>(R.id.images_recycler_view)
        with(rvImageList){
            recyclerViewAdapter = RecyclerViewAdapter()
            adapter = recyclerViewAdapter
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            imageUri = data?.data
            val image = ImageItem(imageUri.toString())
            viewModel.addImageItem(image)
        }
    }
}